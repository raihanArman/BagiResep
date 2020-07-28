package id.co.myproject.bagiresepapp.viewmodel;

import android.app.Application;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import id.co.myproject.bagiresepapp.data.local.repository.BookmarkRepository;
import id.co.myproject.bagiresepapp.data.local.repository.RencanaRepository;
import id.co.myproject.bagiresepapp.data.remote.model.Feedback;
import id.co.myproject.bagiresepapp.data.remote.model.Komentar;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.model.response.BahanResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.KomentarResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.ResepResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.StepsResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.UserResponse;
import id.co.myproject.bagiresepapp.data.remote.repository.FeedbackRepository;
import id.co.myproject.bagiresepapp.data.remote.repository.FollowRepository;
import id.co.myproject.bagiresepapp.data.remote.repository.KomentarRepository;
import id.co.myproject.bagiresepapp.data.remote.repository.LikeRepository;
import id.co.myproject.bagiresepapp.data.remote.repository.ResepRepository;
import id.co.myproject.bagiresepapp.data.remote.repository.UserRepository;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailResepViewModel extends AndroidViewModel {

    private static final String TAG = "DetailResepViewModel";

    private ResepRepository resepRepository;
    private UserRepository userRepository;
    private KomentarRepository komentarRepository;
    private FollowRepository followRepository;
    private LikeRepository likeRepository;
    private BookmarkRepository bookmarkRepository;
    private RencanaRepository rencanaRepository;
    private FeedbackRepository feedbackRepository;

    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<ResepResponse> resepByIdMutable = new MutableLiveData<>();
    private MutableLiveData<Resep> resepByAkunLainnyaMutable = new MutableLiveData<>();
    private MutableLiveData<StepsResponse> stepResepMutable = new MutableLiveData<>();
    private MutableLiveData<BahanResponse> bahanResepMutable = new MutableLiveData<>();
    private MutableLiveData<KomentarResponse> komentarMutable = new MutableLiveData<>();
    private MutableLiveData<UserResponse> userMutable = new MutableLiveData<>();
    private MutableLiveData<UserResponse> userKomentarMutable = new MutableLiveData<>();
    private MutableLiveData<Value> checkFollowMutable = new MutableLiveData<>();
    private MutableLiveData<Value> addFollowMutable = new MutableLiveData<>();
    private MutableLiveData<Value> addLikeMutable = new MutableLiveData<>();
    private MutableLiveData<Value> checkLikeMutable = new MutableLiveData<>();
    private MutableLiveData<List<BookmarkEntity>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Value> inputKomentarMutable = new MutableLiveData<>();
    private MutableLiveData<Value> inputFeedbackMutable = new MutableLiveData<>();



    public DetailResepViewModel(@NonNull Application application) {
        super(application);
        resepRepository = new ResepRepository();
        userRepository = new UserRepository();
        followRepository = new FollowRepository();
        likeRepository = new LikeRepository();
        komentarRepository = new KomentarRepository();
        feedbackRepository = new FeedbackRepository();
        bookmarkRepository = new BookmarkRepository(application);
        rencanaRepository = new RencanaRepository(application);
    }


    public boolean getCheckBookmark(String idResep, String idUser){
        return bookmarkRepository.checkBookmark(idResep, idUser);
    }

    public MutableLiveData<Value> getInputKomentarMutable(Komentar komentar){
        showLoading.setValue(true);
        komentarRepository.inputKomentar(komentar)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Value>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Value value) {
                        inputKomentarMutable.postValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        showLoading.setValue(false);
                        errorMessage.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        showLoading.setValue(false);
                    }
                });
        return inputKomentarMutable;
    }

    public MutableLiveData<Value> getInputFeedbackMutable(Feedback feedback){
        showLoading.setValue(true);
        feedbackRepository.inputFeedback(feedback)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Value>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Value value) {
                        inputFeedbackMutable.postValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        showLoading.setValue(false);
                        errorMessage.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        showLoading.setValue(false);
                    }
                });
        return inputFeedbackMutable;
    }


    public BookmarkEntity getItemBookmark(String idResep, String idUser){
        return bookmarkRepository.getItemBookmark(idResep, idUser);
    }

    public void insertBookmark(BookmarkEntity bookmarkEntity){
        bookmarkRepository.insertBookmark(bookmarkEntity);
    }

    public void removeBookmark(int id){
        bookmarkRepository.removeBookmark(id);
    }



    public boolean getCheckRencana(String idResep, String idUser){
        return rencanaRepository.checkRencana(idResep, idUser);
    }

    public void updateStatusRencana(String status, String idResep){
        rencanaRepository.updateRencana(status, idResep);
    }

    public RencanaEntity getItemRencana(String idResep, String idUser){
        return rencanaRepository.getItemRencana(idResep, idUser);
    }

    public void insertRencana(RencanaEntity rencanaEntity){
        rencanaRepository.insertRencana(rencanaEntity);
    }

    public void removeRencana(int id){
        rencanaRepository.removeRencana(id);
    }


    public MutableLiveData<ResepResponse> getByIdMutable(String idResep){
        showLoading.setValue(true);
        disposable.add(resepRepository.getResepByIdRequest(idResep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(resepResponse -> {
                    showLoading.setValue(false);
                    resepByIdMutable.postValue(resepResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return resepByIdMutable;
    }

    public MutableLiveData<Value> getCheckFollowMutable(String idFollowed, String idFollowing){
        showLoading.setValue(true);
        disposable.add(followRepository.getFollowers(idFollowed, idFollowing)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(value -> {
                        showLoading.setValue(false);
                        checkFollowMutable.postValue(value);
                    }, throwable -> {
                        showLoading.setValue(false);
                        errorMessage.setValue(throwable.getMessage());
                    }));
        return checkFollowMutable;
    }

    public MutableLiveData<Value> getCheckLikeMutable(String idResep, String idUser){
        showLoading.setValue(true);
        disposable.add(likeRepository.getCheckLikeRequest(idResep, idUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(value -> {
                    showLoading.setValue(false);
                    checkLikeMutable.postValue(value);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return checkLikeMutable;
    }

    public MutableLiveData<Value> getAddLikeMutable(String idResep, String idUser){
        showLoading.setValue(true);
        likeRepository.getAddLikeRequest(idResep, idUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Value>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Value value) {
                        Log.d(TAG, "onNext: value like : "+value.getMessage());
                        addLikeMutable.postValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        showLoading.setValue(false);
                        errorMessage.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        showLoading.setValue(false);
                    }
                });
        return addLikeMutable;
    }

    public MutableLiveData<Value> getAddFollowMutable(String idFollowers, String idFollowed, String idFollowing){
        showLoading.setValue(true);
        followRepository.getAddFollowers(idFollowers, idFollowed, idFollowing)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Value>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Value value) {
                        addFollowMutable.postValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        showLoading.setValue(false);
                        errorMessage.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        showLoading.setValue(false);
                    }
                });
        return addFollowMutable;
    }

    public MutableLiveData<Resep> getResepByAkunLainnyaMutable(String idUser, String idResep){
        showLoading.setValue(true);
        disposable.add(resepRepository.getResepByAkunLainnyaRequest(idUser, idResep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(resepResponse -> {
                    showLoading.setValue(false);
                    resepByAkunLainnyaMutable.postValue(resepResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return resepByAkunLainnyaMutable;
    }

    public MutableLiveData<KomentarResponse> getKomentarMutable(String idResep){
        showLoading.setValue(true);
        disposable.add(komentarRepository.getKomentarRequest(idResep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(komentarResponse -> {
                    showLoading.setValue(false);
                    komentarMutable.postValue(komentarResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return komentarMutable;
    }

    public MutableLiveData<StepsResponse> getStepResepMutable(String idResep){
        showLoading.setValue(true);
        disposable.add(resepRepository.getResepStepRequest(idResep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(stepsResponse -> {
                    showLoading.setValue(false);
                    stepResepMutable.postValue(stepsResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return stepResepMutable;
    }

    public MutableLiveData<BahanResponse> getBahanResepMutable(String idResep){
        showLoading.setValue(true);
        disposable.add(resepRepository.getResepBahanRequest(idResep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(bahanResponse -> {
                    showLoading.setValue(false);
                    bahanResepMutable.postValue(bahanResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return bahanResepMutable;
    }

    public MutableLiveData<UserResponse> getUserKomentarMutable(String idUser){
        showLoading.setValue(true);
        disposable.add(userRepository.getUserRequest(idUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(userResponse -> {
                    showLoading.setValue(false);
                    userKomentarMutable.postValue(userResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return userKomentarMutable;
    }

    public MutableLiveData<UserResponse> getUserMutable(String idUser){
        showLoading.setValue(true);
        disposable.add(userRepository.getUserRequest(idUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(userResponse -> {
                    showLoading.setValue(false);
                    userMutable.postValue(userResponse);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return userMutable;
    }

    public MutableLiveData<List<BookmarkEntity>> getBookmark(String idUser){
        showLoading.setValue(true);
        disposable.add(bookmarkRepository.getBookmark(idUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(bookmarkEntities -> {
                    showLoading.setValue(false);
                    mutableLiveData.postValue(bookmarkEntities);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
        return mutableLiveData;
    }




    public LiveData<Boolean> getShowLoading() {
        return showLoading;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null){
            disposable.clear();
            disposable.dispose();
            disposable = null;
        }
    }

}
