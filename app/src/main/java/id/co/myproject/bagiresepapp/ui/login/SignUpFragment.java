package id.co.myproject.bagiresepapp.ui.login;

import android.annotation.SuppressLint;
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

import java.util.UUID;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import id.co.myproject.bagiresepapp.MainActivity;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.FragmentSignUpBinding;
import id.co.myproject.bagiresepapp.data.remote.model.response.LoginResponse;

import static id.co.myproject.bagiresepapp.util.Utils.ID_USER_KEY;
import static id.co.myproject.bagiresepapp.util.Utils.LOGIN_KEY;
import static id.co.myproject.bagiresepapp.util.Utils.LOGIN_STATUS;
import static id.co.myproject.bagiresepapp.ui.login.LoginActivity.loginViewModel;

public class SignUpFragment extends Fragment implements ISignUpFragment{

    private FragmentSignUpBinding binding;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    String idUser;
    private ProgressDialog progressDialog;
    public static final String TAG = SignUpFragment.class.getSimpleName();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private boolean isAtLeast8 = false, hasUppercase = false, hasNumber = false, isRegistrationClickable = false;


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setSignUp(this);

        sharedPreferences = getActivity().getSharedPreferences(LOGIN_KEY, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Proses ...");


        binding.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                registrationDataCheck();
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
                registrationDataCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.etConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                registrationDataCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void checkInput() {
        if (!TextUtils.isEmpty(binding.etEmail.getText())) {
            if (!TextUtils.isEmpty(binding.etNama.getText())) {
                if (!TextUtils.isEmpty(binding.etPassword.getText()) && binding.etConfirmPassword.length() >= 8) {
                    binding.btnSignUp.setEnabled(true);
                    binding.btnSignUp.setTextColor(Color.rgb(255, 255, 255));
                    if (isAtLeast8 && hasUppercase && hasNumber){
                        binding.btnSignUp.setEnabled(true);
                        binding.btnSignUp.setTextColor(Color.rgb(255, 255, 255));
                    }else {
                        binding.btnSignUp.setEnabled(false);
                        binding.btnSignUp.setTextColor(Color.argb(50, 255, 255, 255));
                    }
                } else {
                    binding.btnSignUp.setEnabled(false);
                    binding.btnSignUp.setTextColor(Color.argb(50, 255, 255, 255));
                }
            } else {
                binding.btnSignUp.setEnabled(false);
                binding.btnSignUp.setTextColor(Color.argb(50, 255, 255, 255));
            }
        }else {
            binding.btnSignUp.setEnabled(false);
            binding.btnSignUp.setTextColor(Color.argb(50, 255, 255, 255));
        }
    }

    @SuppressLint("ResourceType")
    private void registrationDataCheck() {
        String password = binding.etPassword.getText().toString(), email = binding.etEmail.getText().toString();

        if (password.length() >= 8) {
            isAtLeast8 = true;
            binding.cvKarakter.setCardBackgroundColor(Color.parseColor(getString(R.color.colorCheckOk)));
        } else {
            isAtLeast8 = false;
            binding.cvKarakter.setCardBackgroundColor(Color.parseColor(getString(R.color.colorCheckNo)));
        }
        if (password.matches("(.*[A-Z].*)")) {
            hasUppercase = true;
            binding.cvUppercase.setCardBackgroundColor(Color.parseColor(getString(R.color.colorCheckOk)));
        } else {
            hasUppercase = false;
            binding.cvUppercase.setCardBackgroundColor(Color.parseColor(getString(R.color.colorCheckNo)));
        }
        if (password.matches("(.*[0-9].*)")) {
            hasNumber = true;
            binding.cvAngka.setCardBackgroundColor(Color.parseColor(getString(R.color.colorCheckOk)));
        } else {
            hasNumber = false;
            binding.cvAngka.setCardBackgroundColor(Color.parseColor(getString(R.color.colorCheckNo)));
        }

        checkInput();
    }


    @Override
    public void registerProses() {
        String id = UUID.randomUUID().toString();
        String nama = binding.etNama.getText().toString();
        String email = binding.etEmail.getText().toString();
        String password = binding.etPassword.getText().toString();
        loginViewModel.getRegisterMutable(id, nama, email, password)
                .observe(this, new Observer<LoginResponse>() {
                    @Override
                    public void onChanged(LoginResponse loginResponse) {
                        Toast.makeText(getActivity(), ""+loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        if (loginResponse.getValue() == 1){
                            idUser = loginResponse.getUser().getId();
                            editor.putString(ID_USER_KEY, idUser);
                            editor.putBoolean(LOGIN_STATUS, true);
                            editor.commit();
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            getActivity().startActivity(intent);
                            getActivity().finish();
                        }else {
                            binding.btnSignUp.setEnabled(true);
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


    @Override
    public void goSignIn() {
        setFragment(new SignInFragment());
    }

    public void setFragment(Fragment fragment){
        FrameLayout parentLayout = ((LoginActivity)binding.getRoot().getContext()).activityLoginBinding.frameLogin;
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(parentLayout.getId(), fragment);
        transaction.commit();
    }
}
