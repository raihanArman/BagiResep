package id.co.myproject.bagiresepapp.data.remote.repository;

import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.response.BahanResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.ResepResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.StepsResponse;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Observable;

public class ResepRepository {
    private ApiService apiService;

    public ResepRepository() {
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public Observable<ResepResponse> getResepRequest(){
        return apiService.resepRequest();
    }

    public Observable<ResepResponse> getResepPopularRequest(){
        return apiService.popularRequest();
    }

    public Observable<StepsResponse> getResepStepRequest(String idResep){
        return apiService.stepsResepRequest(idResep);
    }

    public Observable<BahanResponse> getResepBahanRequest(String idResep){
        return apiService.bahanResepRequest(idResep);
    }

    public Observable<ResepResponse> getResepByIdRequest(String idResep){
        return apiService.resepByIdRequest(idResep);
    }

    public Observable<Resep> getResepByAkunLainnyaRequest(String idUser, String idResep){
        return apiService.resepByAkunLainnyaRequest(idUser, idResep);
    }

}
