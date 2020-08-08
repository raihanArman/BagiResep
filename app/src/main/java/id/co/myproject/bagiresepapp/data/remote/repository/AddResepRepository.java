package id.co.myproject.bagiresepapp.data.remote.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity;
import id.co.myproject.bagiresepapp.data.remote.model.Bahan;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.Steps;
import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.model.response.KategoriResponse;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddResepRepository {
    private ApiService apiService;
    private MutableLiveData<Value> inputBahanMutable = new MutableLiveData<>();
    private MutableLiveData<Value> inputLangkahMutable = new MutableLiveData<>();

    public AddResepRepository() {
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }


    public Call<Value> inputResepRequest(Resep resep){
        return apiService.inputResepRequest(resep);
    }

    public MutableLiveData inputBahanRequest(Bahan bahan){
        apiService.inputBahanRequest(bahan)
                .enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        inputBahanMutable.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {

                    }
                });
        return inputBahanMutable;
    }

    public MutableLiveData inputLangkahRequest(Steps steps){
        apiService.inputLangkahRequest(steps)
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

    public Call<Value> inputLangkahGambarRequest(LangkahGambarEntity langkahGambarEntity){
        return apiService.inputLangkahGambarRequest(langkahGambarEntity);
    }
}
