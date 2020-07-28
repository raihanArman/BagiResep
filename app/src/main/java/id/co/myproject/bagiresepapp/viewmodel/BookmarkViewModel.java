package id.co.myproject.bagiresepapp.viewmodel;

import android.app.Application;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import id.co.myproject.bagiresepapp.data.local.repository.BookmarkRepository;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BookmarkViewModel extends ViewModel {
    private BookmarkRepository bookmarkRepository;
    private MutableLiveData<List<BookmarkEntity>> mutableLiveData = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public BookmarkViewModel(@NonNull Application application) {
        super();
        bookmarkRepository = new BookmarkRepository(application);
    }

    public MutableLiveData<List<BookmarkEntity>> getBookmark(String idUser){
        showLoading.setValue(true);
        compositeDisposable.add(bookmarkRepository.getBookmark(idUser)
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

    public void insertBookmark(BookmarkEntity bookmarkEntity){
        bookmarkRepository.insertBookmark(bookmarkEntity);
    }

    public void removeBookmark(int id){
        bookmarkRepository.removeBookmark(id);
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
        if (compositeDisposable != null){
            compositeDisposable.clear();
            compositeDisposable.dispose();
            compositeDisposable = null;
        }
    }

}
