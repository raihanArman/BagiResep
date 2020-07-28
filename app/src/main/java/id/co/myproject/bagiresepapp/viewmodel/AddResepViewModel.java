package id.co.myproject.bagiresepapp.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.co.myproject.bagiresepapp.data.local.entity.BahanEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity;
import id.co.myproject.bagiresepapp.data.local.repository.BahanRepository;
import id.co.myproject.bagiresepapp.data.local.repository.LangkahRepository;
import id.co.myproject.bagiresepapp.data.remote.model.Bahan;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.Steps;
import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.model.response.KategoriResponse;
import id.co.myproject.bagiresepapp.data.remote.repository.AddResepRepository;
import id.co.myproject.bagiresepapp.data.remote.repository.KategoriRepository;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddResepViewModel extends AndroidViewModel {
    private KategoriRepository kategoriRepository;
    private BahanRepository bahanRepository;
    private LangkahRepository langkahRepository;
    private AddResepRepository addResepRepository;
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<KategoriResponse> kategoriMutable = new MutableLiveData<>();
    private MutableLiveData<List<BahanEntity>> bahanMutable = new MutableLiveData<>();
    private MutableLiveData<List<LangkahEntity>> langkahMutable = new MutableLiveData<>();
    private MutableLiveData<Value> inputResepMutable = new MutableLiveData<>();
    private MutableLiveData<Value> inputBahanMutable = new MutableLiveData<>();
    private MutableLiveData<Value> inputLangkahMutable = new MutableLiveData<>();
    private MutableLiveData<Value> inputLangkahGambarMutable = new MutableLiveData<>();

    Context context;
    public AddResepViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        kategoriRepository = new KategoriRepository();
        bahanRepository = new BahanRepository(application);
        langkahRepository = new LangkahRepository(application);
        addResepRepository = new AddResepRepository();
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

    public MutableLiveData<List<BahanEntity>> getBahanMutable(){
        showLoading.setValue(true);
        disposable.add(bahanRepository.getBahanList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(bahanEntities -> {
                    showLoading.setValue(false);
                    bahanMutable.postValue(bahanEntities);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return bahanMutable;
    }

    public void insertBahan(BahanEntity bahanEntity){
        bahanRepository.insertToBahan(bahanEntity);
    }

    public void updateBahan(int idBahan, String bahan){
        bahanRepository.updateBahan(idBahan, bahan);
    }

    public void removeBahan(int idBahan){
        bahanRepository.removeBahanById(idBahan);
    }

    public void removeAllBahan(){
        bahanRepository.removeAllBahan();
    }

    public void removeAllLangkah(){
        langkahRepository.removeAllLangkah();
    }

    public List<BahanGambarEntity> getBahanGambarMutable(int idBahan){
        return bahanRepository.getBahanGambar(idBahan);
    }

    public void insertBahanGambar(BahanGambarEntity bahanGambarEntity){
        bahanRepository.insertBahanGambar(bahanGambarEntity);
    }

    public void removeBahanGambarById(int idBahanGambar){
        bahanRepository.removeBahanGambarById(idBahanGambar);
    }

    public void removeBahanGambarByIdBahan(int idBahan){
        bahanRepository.removeBahanGambarByIdBahan(idBahan);
    }

//    Langkah
    public MutableLiveData<List<LangkahEntity>> getLangkahMutable(){
        showLoading.setValue(true);
        disposable.add(langkahRepository.getLangkahList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(langkahEntities -> {
                    showLoading.setValue(false);
                    langkahMutable.postValue(langkahEntities);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return langkahMutable;
    }

    public void insertLangkah(LangkahEntity langkahEntity){
        langkahRepository.insertToLangkah(langkahEntity);
    }

    public void updateLangkah(int idLangkah, String langkah){
        langkahRepository.updateLangkah(idLangkah, langkah);
    }

    public void removeLangkahById(int idLangkah){
        langkahRepository.removeLangkahById(idLangkah);
    }

//    LangkahGambar
    public List<LangkahGambarEntity> getLangkahGambarMutable(int idLangkah){
        return langkahRepository.getLangkahGambar(idLangkah);
    }

    public void insertLangkahGambar(LangkahGambarEntity langkahGambarEntity){
        langkahRepository.insertLangkahGambar(langkahGambarEntity);
    }

    public void removeLangkahGambarById(int idLangkahGambar){
        langkahRepository.removeLangkahGambarById(idLangkahGambar);
    }

    public void removeLangkahGambarByIdLangkah(int idLangkah){
        langkahRepository.removeLangkahGambarByIdLangkah(idLangkah);
    }

    public MutableLiveData<Value> getInputResepMutable(Resep resep){
        showLoading.setValue(true);
        addResepRepository.inputResepRequest(resep)
                .enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        showLoading.setValue(false);
                        inputResepMutable.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {
                        errorMessage.setValue(t.getMessage());
                    }
                });
        return inputResepMutable;
    }

    public MutableLiveData<Value> getInputBahanMutable(Bahan bahan){
        showLoading.setValue(true);
        addResepRepository.inputBahanRequest(bahan)
                .enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        showLoading.setValue(false);
                        inputBahanMutable.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {
                        errorMessage.setValue(t.getMessage());
                    }
                });
        return inputBahanMutable;
    }

    public MutableLiveData<Value> getInputLangkahMutable(Steps steps){
        showLoading.setValue(true);
        addResepRepository.inputLangkahRequest(steps)
                .enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        inputLangkahMutable.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {

                    }
                });
        return inputLangkahMutable;
    }

    public MutableLiveData<Value> getInputLangkahGambarMutable(LangkahGambarEntity langkahGambarEntity){
        showLoading.setValue(true);
        addResepRepository.inputLangkahGambarRequest(langkahGambarEntity)
                .enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        inputLangkahGambarMutable.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {

                    }
                });

        return inputLangkahGambarMutable;
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
