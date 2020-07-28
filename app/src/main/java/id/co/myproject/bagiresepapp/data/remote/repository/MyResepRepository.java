package id.co.myproject.bagiresepapp.data.remote.repository;

import id.co.myproject.bagiresepapp.data.remote.model.response.ResepResponse;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Observable;

public class MyResepRepository {
    private ApiService apiService;

    public MyResepRepository(){
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public Observable<ResepResponse> getResepSaya(String iduser){
        return apiService.getResepSaya(iduser);
    }

}
