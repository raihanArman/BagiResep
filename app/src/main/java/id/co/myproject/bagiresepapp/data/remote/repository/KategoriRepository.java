package id.co.myproject.bagiresepapp.data.remote.repository;

import id.co.myproject.bagiresepapp.data.remote.model.response.KategoriResponse;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Observable;

public class KategoriRepository {
    private ApiService apiService;

    public KategoriRepository() {
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public Observable<KategoriResponse> getKategoriRequest(){
        return apiService.kategoriRequest();
    }

}
