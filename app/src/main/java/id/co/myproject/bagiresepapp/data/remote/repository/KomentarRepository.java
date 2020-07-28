package id.co.myproject.bagiresepapp.data.remote.repository;

import id.co.myproject.bagiresepapp.data.remote.model.Komentar;
import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.model.response.KomentarResponse;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Observable;
import io.reactivex.Single;

public class KomentarRepository {
    private ApiService apiService;

    public KomentarRepository(){
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public Observable<KomentarResponse> getKomentarRequest(String idresep){
        return apiService.komentarRequest(idresep);
    }

    public Observable<Value> inputKomentar(Komentar komentar){
        return apiService.inputKomentar(komentar);
    }

}
