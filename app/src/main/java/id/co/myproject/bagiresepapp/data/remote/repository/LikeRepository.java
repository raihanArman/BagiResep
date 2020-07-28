package id.co.myproject.bagiresepapp.data.remote.repository;

import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Observable;

public class LikeRepository {
    private ApiService apiService;

    public LikeRepository() {
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public Observable<Value> getAddLikeRequest(String idResep, String idUser){
        return apiService.addLike(idResep, idUser);
    }

    public Observable<Value> getCheckLikeRequest(String idResep, String idUser){
        return apiService.cekLike(idResep, idUser);
    }

}
