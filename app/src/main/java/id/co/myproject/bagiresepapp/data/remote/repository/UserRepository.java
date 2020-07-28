package id.co.myproject.bagiresepapp.data.remote.repository;

import id.co.myproject.bagiresepapp.data.remote.model.response.UserResponse;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Single;

public class UserRepository {
    private ApiService apiService;

    public UserRepository() {
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public Single<UserResponse> getUserRequest(String idUser){
        return apiService.userRequest(idUser);
    }

}
