package id.co.myproject.bagiresepapp.ui.login;

import android.annotation.SuppressLint;
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
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.ScaleAnimation;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.transition.TransitionManager;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.FragmentForgotPassBinding;
import id.co.myproject.bagiresepapp.data.remote.model.response.LoginResponse;

import static id.co.myproject.bagiresepapp.ui.login.LoginActivity.loginViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPassFragment extends Fragment implements IForgotPass{

    private FragmentForgotPassBinding binding;
    private static final String TAG = "ForgotPassFragment";

    public ForgotPassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_pass, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setForgotPass(this);

        binding.etForgotPasswordEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void checkEmail() {
        TransitionManager.beginDelayedTransition(binding.forgotPasswordEmailContainer);
        binding.forgotPasswordEmailIcon.setVisibility(View.GONE);

        TransitionManager.beginDelayedTransition(binding.forgotPasswordEmailContainer);
        binding.forgotPasswordEmailIcon.setVisibility(View.VISIBLE);
        binding.forgotPasswordProgress.setVisibility(View.VISIBLE);

        binding.btnResetPassword.setEnabled(false);
        loginViewModel.getCheckEmailMutable(binding.etForgotPasswordEmail.getText().toString())
                .observe(this, new Observer<LoginResponse>() {
                    @Override
                    public void onChanged(LoginResponse loginResponse) {
                        if (loginResponse.getValue() == 1){
                            ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0, 1, 0, binding.forgotPasswordEmailIcon.getWidth()/2, binding.forgotPasswordEmailIcon.getWidth()/2);
                            scaleAnimation.setDuration(100);
                            scaleAnimation.setInterpolator(new AnticipateInterpolator());
                            scaleAnimation.setRepeatMode(Animation.REVERSE);
                            scaleAnimation.setRepeatCount(1);
                            scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    binding.forgotPasswordEmailText.setVisibility(View.VISIBLE);
                                    binding.forgotPasswordEmailText.setText("Email berhasil ditemukan");
                                    binding.forgotPasswordEmailText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                                    TransitionManager.beginDelayedTransition(binding.forgotPasswordEmailContainer);
                                    FragmentManager fm = getActivity().getSupportFragmentManager();
                                    String idUser = loginResponse.getUser().getId();

                                    ForgotPassDialogFragment forgotPassDialogFragment = new ForgotPassDialogFragment(idUser);
                                    forgotPassDialogFragment.setTargetFragment(ForgotPassFragment.this, 300);
                                    forgotPassDialogFragment.show(fm, "");

                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {
                                    binding.forgotPasswordEmailIcon.setImageResource(R.drawable.mail_green);
                                }
                            });
                            binding.forgotPasswordEmailIcon.startAnimation(scaleAnimation);
                        }else {
                            binding.btnResetPassword.setEnabled(true);
                            binding.forgotPasswordEmailText.setText(loginResponse.getMessage());
                            binding.forgotPasswordEmailText.setTextColor(getResources().getColor(R.color.colorPrimary));
                            TransitionManager.beginDelayedTransition(binding.forgotPasswordEmailContainer);
                            binding.forgotPasswordEmailIcon.setVisibility(View.VISIBLE);
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

        } else {

        }
    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(binding.etForgotPasswordEmail.getText())){
            binding.btnResetPassword.setEnabled(true);
        }else {
            binding.btnResetPassword.setEnabled(false);
        }
    }

    @SuppressLint("LongLogTag")
    private void printErrorMessage(String message) {
        Log.d(TAG + "error : ", message);
    }


    @Override
    public void goBack() {
        getActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    @Override
    public void backToSignIn(boolean hasReset) {
        if (hasReset){
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        }
    }

}
