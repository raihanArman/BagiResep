package id.co.myproject.bagiresepapp.data.remote.repository;

import id.co.myproject.bagiresepapp.data.remote.model.Feedback;
import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.request.ApiService;
import id.co.myproject.bagiresepapp.data.remote.request.RetrofitRequest;
import io.reactivex.Observable;

public class FeedbackRepository {
    private ApiService apiService;

    public FeedbackRepository() {
        this.apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public Observable<Value> inputFeedback(Feedback feedback){
        return apiService.inputFeedback(feedback);
    }

}
