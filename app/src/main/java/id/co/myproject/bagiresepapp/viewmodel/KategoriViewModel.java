package id.co.myproject.bagiresepapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.co.myproject.bagiresepapp.data.remote.model.response.KategoriResponse;
import id.co.myproject.bagiresepapp.data.remote.repository.KategoriRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class KategoriViewModel extends ViewModel {
    private KategoriRepository kategoriRepository;
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<KategoriResponse> kategoriMutable = new MutableLiveData<>();

    public KategoriViewModel() {
        kategoriRepository = new KategoriRepository();
    }

    public MutableLiveData<KategoriResponse> getKategoriMutable(){
        showLoading.setValue(true);
        disposable.add(kategoriRepository.getKategoriRequest()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(kategoriResponse -> {
                        showLoading.setValue(false);
                        kategoriMutable.postValue(kategoriResponse);
                    }, throwable -> {
                        showLoading.setValue(false);
                        errorMessage.setValue(throwable.getMessage());
                    }));
        return kategoriMutable;
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
