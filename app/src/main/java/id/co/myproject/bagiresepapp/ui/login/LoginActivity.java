package id.co.myproject.bagiresepapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import id.co.myproject.bagiresepapp.MainActivity;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.ActivityLoginBinding;
import id.co.myproject.bagiresepapp.viewmodel.LoginViewModel;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import static id.co.myproject.bagiresepapp.util.Utils.LOGIN_KEY;
import static id.co.myproject.bagiresepapp.util.Utils.LOGIN_STATUS;

public class LoginActivity extends AppCompatActivity {

    public ActivityLoginBinding activityLoginBinding;
    private SharedPreferences sharedPreferences;
    private ProgressDialog progressDialog;
    public static LoginViewModel loginViewModel;
    ViewModelProvider.Factory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        sharedPreferences = getSharedPreferences(LOGIN_KEY, Context.MODE_PRIVATE);

        factory = new ViewModelProvider.NewInstanceFactory();
        loginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Mohon tunggu");
        progressDialog.setMessage("Proses ...");
        progressDialog.setCancelable(false);

        cekLogin();

    }


    public void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(activityLoginBinding.frameLogin.getId(), fragment);
        transaction.commit();
    }

    private void cekLogin() {
        progressDialog.show();
        boolean statusLogin = sharedPreferences.getBoolean(LOGIN_STATUS, false);
        if (statusLogin){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            progressDialog.dismiss();
            setFragment(new SignInFragment());
        }
    }
}
