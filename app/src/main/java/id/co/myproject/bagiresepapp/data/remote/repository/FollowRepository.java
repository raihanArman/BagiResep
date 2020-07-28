package id.co.myproject.bagiresepapp.data.remote.repository;

import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Observable;

public class FollowRepository {
    private ApiService apiService;

    public FollowRepository() {
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public Observable<Value> getFollowers(String idFollowed, String idFollowing){
        return apiService.cekFollowers(idFollowed, idFollowing);
    }

    public Observable<Value> getAddFollowers(String idFollowers, String idFollowed, String idFollowing){
        return apiService.addFollowers(idFollowers, idFollowed, idFollowing);
    }

}
