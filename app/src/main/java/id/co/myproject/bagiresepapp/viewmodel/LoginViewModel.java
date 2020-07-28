package id.co.myproject.bagiresepapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.model.response.LoginResponse;
import id.co.myproject.bagiresepapp.data.remote.repository.LoginRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {
    private LoginRepository loginRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<LoginResponse> loginMutable = new MutableLiveData<>();
    private MutableLiveData<LoginResponse> checkEmailMutable = new MutableLiveData<>();
    private MutableLiveData<Value> forgotPassMutable = new MutableLiveData<>();

    public LoginViewModel(){
        loginRepository = new LoginRepository();
    }

    public MutableLiveData<LoginResponse> getLoginMutable(String email, String password){
        showLoading.setValue(true);
        disposable.add(loginRepository.loginRequest(email, password)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(login -> {
                        showLoading.setValue(false);
                        loginMutable.postValue(login);
                    }, throwable -> {
                        showLoading.setValue(false);
                        errorMessage.setValue(throwable.getMessage());
                    }));
        return loginMutable;
    }

    public MutableLiveData<Value> getResetPassMutable(String id, String password){
        showLoading.setValue(true);
        disposable.add(loginRepository.forgotPassRequest(id, password)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(value -> {
                        showLoading.setValue(false);
                        forgotPassMutable.postValue(value);
                    }, throwable -> {
                        showLoading.setValue(false);
                        errorMessage.setValue(throwable.getMessage());
                    }));
        return forgotPassMutable;
    }

    public MutableLiveData<LoginResponse> getCheckEmailMutable(String email){
        showLoading.setValue(true);
        disposable.add(loginRepository.cekEmailRequest(email)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(emailCek -> {
                        showLoading.setValue(false);
                        checkEmailMutable.postValue(emailCek);
                    }, throwable -> {
                        showLoading.setValue(false);
                        errorMessage.setValue(throwable.getMessage());
                    }));
        return checkEmailMutable;
    }

    public MutableLiveData<LoginResponse> getRegisterMutable(String id, String nama, String email, String password){
        showLoading.setValue(true);
        disposable.add(loginRepository.registerRequest(id, nama, email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(login -> {
                    showLoading.setValue(false);
                    loginMutable.postValue(login);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return loginMutable;
    }


    public LiveData<Boolean> getShowLoading() {
        return showLoading;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null){
            disposable.clear();
            disposable.dispose();
            disposable = null;
        }
    }
}
