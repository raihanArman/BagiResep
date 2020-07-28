package id.co.myproject.bagiresepapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.co.myproject.bagiresepapp.data.remote.model.response.UserResponse;
import id.co.myproject.bagiresepapp.data.remote.repository.UserRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    private MutableLiveData<UserResponse> userMutable = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public UserViewModel() {
        userRepository = new UserRepository();
    }

    public MutableLiveData<UserResponse> getUserMutable(String idUser){
        showLoading.setValue(true);
        disposable.add(userRepository.getUserRequest(idUser)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(userResponse -> {
                        showLoading.setValue(false);
                        userMutable.postValue(userResponse);
                    }, throwable -> {
                        showLoading.setValue(false);
                        errorMessage.setValue(throwable.getMessage());
                    }));
        return userMutable;
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
