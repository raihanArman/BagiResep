package id.co.myproject.bagiresepapp.ui.login;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
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
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.FragmentForgotPassDialogBinding;
import id.co.myproject.bagiresepapp.data.remote.model.Value;

import static id.co.myproject.bagiresepapp.ui.login.LoginActivity.loginViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPassDialogFragment extends DialogFragment implements IForgotPassDialog{

    private static final String TAG = "ForgotPassDialogFragmen";
    String idUser;
    private FragmentForgotPassDialogBinding binding;
    private ProgressDialog progressDialog;
    private boolean isAtLeast8 = false, hasUppercase = false, hasNumber = false, isRegistrationClickable = false;

    public ForgotPassDialogFragment(String idUser) {
        // Required empty public constructor
        this.idUser = idUser;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_pass_dialog, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setForgotDialog(this);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Proses ...");

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

    @Override
    public void resetPassword() {
        if (!TextUtils.isEmpty(binding.etPassword.getText().toString()) && !TextUtils.isEmpty(binding.etConfirmPassword.getText().toString())) {
            if (binding.etPassword.getText().toString().equals(binding.etConfirmPassword.getText().toString())) {
                if (binding.etPassword.getText().length() >= 8 && binding.etConfirmPassword.getText().length() >= 8) {
                    resetPasswordProses(binding.etPassword.getText().toString());
                } else {
                    Toast.makeText(getActivity(), "Password harus lebih dari 8 karakter", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "Password tidak cocok", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetPasswordProses(String password) {
        loginViewModel.getResetPassMutable(idUser, password)
                .observe(this, new Observer<Value>() {
                    @Override
                    public void onChanged(Value value) {
                        Toast.makeText(getActivity(), "" + value.getMessage(), Toast.LENGTH_SHORT).show();
                        if (value.getValue() == 1) {
                            FrameLayout parentLayout = ((LoginActivity)getActivity()).activityLoginBinding.frameLogin;
                            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(parentLayout.getId(), new SignInFragment());
                            fragmentTransaction.commit();
                            dismiss();
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
        Log.d(TAG, "printErrorMessage: "+message);
    }

    @Override
    public void batalReset() {
        getActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    @SuppressLint("ResourceType")
    private void registrationDataCheck() {
        String password = binding.etPassword.getText().toString();

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

    private void checkInput() {
        if (!TextUtils.isEmpty(binding.etPassword.getText()) && binding.etPassword.length() >= 8) {
            binding.tvSelesai.setEnabled(true);
            binding.tvSelesai.setTextColor(Color.rgb(255, 255, 255));
            if (isAtLeast8 && hasUppercase && hasNumber){
                binding.tvSelesai.setEnabled(true);
                binding.tvSelesai.setTextColor(getResources().getColor(R.color.colorAccent));
            }else {
                binding.tvSelesai.setEnabled(false);
                binding.tvSelesai.setTextColor(Color.argb(50, 255, 255, 255));
            }
        } else {
            binding.tvSelesai.setEnabled(false);
            binding.tvSelesai.setTextColor(Color.argb(50, 255, 255, 255));
        }
    }
}
