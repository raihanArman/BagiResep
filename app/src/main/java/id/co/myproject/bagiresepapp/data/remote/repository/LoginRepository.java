package id.co.myproject.bagiresepapp.data.remote.repository;

import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.model.response.LoginResponse;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Observable;

public class LoginRepository {
    private ApiService apiService;

    public LoginRepository(){
        this.apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public Observable<LoginResponse> loginRequest(String email, String password){
        return apiService.loginUserRequest(email, password);
    }

    public Observable<LoginResponse> registerRequest(String id, String nama, String email, String password){
        return apiService.registerUserRequest(id, nama, email, password);
    }

    public Observable<LoginResponse> cekEmailRequest(String email){
        return apiService.cekEmailRequest(email);
    }

    public Observable<Value> forgotPassRequest(String idUser, String email){
        return apiService.lupaPasswordRequest(idUser, email);
    }

}
