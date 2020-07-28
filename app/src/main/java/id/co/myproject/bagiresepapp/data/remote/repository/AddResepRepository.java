package id.co.myproject.bagiresepapp.data.remote.repository;

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

public class AddResepRepository {
    private ApiService apiService;

    public AddResepRepository() {
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }


    public Call<Value> inputResepRequest(Resep resep){
        return apiService.inputResepRequest(resep);
    }

    public Call<Value> inputBahanRequest(Bahan bahan){
        return apiService.inputBahanRequest(bahan);
    }

    public Call<Value> inputLangkahRequest(Steps steps){
        return apiService.inputLangkahRequest(steps);
    }

    public Call<Value> inputLangkahGambarRequest(LangkahGambarEntity langkahGambarEntity){
        return apiService.inputLangkahGambarRequest(langkahGambarEntity);
    }
}
