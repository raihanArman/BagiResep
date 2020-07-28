package id.co.myproject.bagiresepapp.ui.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import id.co.myproject.bagiresepapp.MainActivity;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.FragmentSignInBinding;
import id.co.myproject.bagiresepapp.data.remote.model.response.LoginResponse;

import static id.co.myproject.bagiresepapp.util.Utils.ID_USER_KEY;
import static id.co.myproject.bagiresepapp.util.Utils.LOGIN_KEY;
import static id.co.myproject.bagiresepapp.util.Utils.LOGIN_STATUS;
import static id.co.myproject.bagiresepapp.ui.login.LoginActivity.loginViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment implements ISignInFragment{

    private static final String TAG = "SignInFragment";

    private FragmentSignInBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    ProgressDialog progressDialog;
    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setSignIn(this);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Memproses ...");
        sharedPreferences = getActivity().getSharedPreferences(LOGIN_KEY, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekForm();
            }
        });

        binding.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void cekForm(){
        String email = binding.etEmail.getText().toString();
        String password = binding.etPassword.getText().toString();
        if (email.matches(emailPattern)) {
            if (password.length() >= 8) {
                progressDialog.show();
                binding.btnSignIn.setEnabled(true);
                prosesLogin(email, password);
            } else {
                Toast.makeText(getActivity(), "Password kurang boss", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "Username atau Password salah boss", Toast.LENGTH_SHORT).show();
        }

    }

    private void prosesLogin(String email, String password) {
        loginViewModel.getLoginMutable(email, password)
                .observe(this, new Observer<LoginResponse>() {
                    @Override
                    public void onChanged(LoginResponse loginResponse) {
                        Toast.makeText(getActivity(), ""+loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        if (loginResponse.getValue() == 1){
                            editor.putString(ID_USER_KEY, loginResponse.getUser().getId());
                            editor.putBoolean(LOGIN_STATUS, true);
                            editor.commit();
                            updateUI();
                        }else {
                            binding.btnSignIn.setEnabled(true);
                        }
                    }
                });
        loginViewModel.getShowLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showLoading(aBoolean);
            }
        });
        loginViewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                printErrorMessage(s);
            }
        });
    }

    private void showLoading(Boolean isShowLoading) {
        if (isShowLoading) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    private void printErrorMessage(String message) {
        Log.d(TAG + "error : ", message);
    }

    private void updateUI() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Proses ...");
        progressDialog.show();
        boolean statusLogin = sharedPreferences.getBoolean(LOGIN_STATUS, false);
        if (statusLogin){
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        }else {
            progressDialog.dismiss();
        }
    }

    private void checkInput() {
        if (!TextUtils.isEmpty(binding.etEmail.getText())) {
            if (!TextUtils.isEmpty(binding.etPassword.getText())) {
                binding.btnSignIn.setEnabled(true);
                binding.btnSignIn.setTextColor(Color.rgb(255, 255, 255));
            } else {
                binding.btnSignIn.setEnabled(false);
                binding.btnSignIn.setTextColor(Color.argb(50, 255, 255, 255));
            }
        } else {
            binding.btnSignIn.setEnabled(false);
            binding.btnSignIn.setTextColor(Color.argb(50, 255, 255, 255));
        }
    }

    @Override
    public void loginProses() {
        cekForm();
    }

    @Override
    public void goForgotPass() {
        setFragment(new ForgotPassFragment());
    }

    @Override
    public void goSignUp() {
        setFragment(new SignUpFragment());
    }

    public void setFragment(Fragment fragment){
        FrameLayout parentLayout = ((LoginActivity)binding.getRoot().getContext()).activityLoginBinding.frameLogin;
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(parentLayout.getId(), fragment);
        transaction.commit();
    }

}
