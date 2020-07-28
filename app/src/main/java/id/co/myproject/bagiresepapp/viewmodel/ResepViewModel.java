package id.co.myproject.bagiresepapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.co.myproject.bagiresepapp.data.remote.model.response.BahanResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.ResepResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.StepsResponse;
import id.co.myproject.bagiresepapp.data.remote.repository.ResepRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ResepViewModel extends ViewModel {
    private ResepRepository resepRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<ResepResponse> resepMutable = new MutableLiveData<>();
    private MutableLiveData<ResepResponse> resepByIdMutable = new MutableLiveData<>();
    private MutableLiveData<ResepResponse> popularMutable = new MutableLiveData<>();
    private MutableLiveData<StepsResponse> stepResepMutable = new MutableLiveData<>();
    private MutableLiveData<BahanResponse> bahanResepMutable = new MutableLiveData<>();

    public ResepViewModel() {
        resepRepository = new ResepRepository();
    }

    public MutableLiveData<ResepResponse> getPopularMutable(){
        showLoading.setValue(true);
        disposable.add(resepRepository.getResepPopularRequest()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(resepResponse -> {
                        showLoading.setValue(false);
                        popularMutable.postValue(resepResponse);
                    }, throwable -> {
                        showLoading.setValue(false);
                        errorMessage.setValue(throwable.getMessage());
                    }));
        return popularMutable;
    }

    public MutableLiveData<ResepResponse> getResepMutable(){
        showLoading.setValue(true);
        disposable.add(resepRepository.getResepRequest()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(resepResponse -> {
                    showLoading.setValue(false);
                    resepMutable.postValue(resepResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return resepMutable;
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
