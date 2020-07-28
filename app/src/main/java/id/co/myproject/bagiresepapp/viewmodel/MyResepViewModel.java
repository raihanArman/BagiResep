package id.co.myproject.bagiresepapp.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import id.co.myproject.bagiresepapp.data.local.repository.RencanaRepository;
import id.co.myproject.bagiresepapp.data.remote.model.response.ResepResponse;
import id.co.myproject.bagiresepapp.data.remote.repository.MyResepRepository;
import id.co.myproject.bagiresepapp.data.remote.repository.ResepRepository;
import id.co.myproject.bagiresepapp.util.Utils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MyResepViewModel extends AndroidViewModel {
    private MyResepRepository myResepRepository;
    private RencanaRepository rencanaRepository;
    private ResepRepository resepRepository;

    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<ResepResponse> resepResponseMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<RencanaEntity>> rencanaMutable = new MutableLiveData<>();
    private MutableLiveData<List<RencanaEntity>> sudahMasakMutable = new MutableLiveData<>();
    private MutableLiveData<ResepResponse> resepByIdMutable = new MutableLiveData<>();


    public MyResepViewModel(@NonNull Application application) {
        super(application);
        resepRepository = new ResepRepository();
        myResepRepository = new MyResepRepository();
        rencanaRepository = new RencanaRepository(application);
    }

    public MutableLiveData<List<RencanaEntity>> getRencanaMutable(String idUser){
        showLoading.setValue(true);
        disposable.add(rencanaRepository.getRencana(idUser, Utils.STATUS_BELUM_MASAK)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(rencanaEntities -> {
                    showLoading.setValue(false);
                    rencanaMutable.postValue(rencanaEntities);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return rencanaMutable;
    }

    public MutableLiveData<List<RencanaEntity>> getSudahMasakMutable(String idUser){
        showLoading.setValue(true);
        disposable.add(rencanaRepository.getRencana(idUser, Utils.STATUS_SUDAH_MASAK)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(rencanaEntities -> {
                    showLoading.setValue(false);
                    sudahMasakMutable.postValue(rencanaEntities);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return sudahMasakMutable;
    }

    public MutableLiveData<ResepResponse> getResepByIdMutable(String idResep){
        showLoading.setValue(true);
        disposable.add(resepRepository.getResepByIdRequest(idResep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(resepResponse -> {
                    showLoading.setValue(false);
                    resepByIdMutable.postValue(resepResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return resepByIdMutable;
    }

    public MutableLiveData<ResepResponse> getMyResepMutableLiveData(String idUser){
        showLoading.setValue(true);
        disposable.add(myResepRepository.getResepSaya(idUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(resepResponse -> {
                    showLoading.setValue(false);
                    resepResponseMutableLiveData.postValue(resepResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return resepResponseMutableLiveData;
    }

    public void removeRencana(int id){
        rencanaRepository.removeRencana(id);
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
