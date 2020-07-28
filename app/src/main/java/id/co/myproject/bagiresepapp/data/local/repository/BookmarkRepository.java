package id.co.myproject.bagiresepapp.data.local.repository;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import id.co.myproject.bagiresepapp.data.local.AppDatabase;
import id.co.myproject.bagiresepapp.data.local.DatabaseManager;
import id.co.myproject.bagiresepapp.data.local.IDatabaseManager;
import id.co.myproject.bagiresepapp.data.local.dao.DatabaseDao;
import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import io.reactivex.Observable;

public class BookmarkRepository {
    private DatabaseDao databaseDao;

    public BookmarkRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getAppDatabase(application);
        databaseDao = appDatabase.databaseDao();
    }

    public Observable<List<BookmarkEntity>> getBookmark(String idUser){
        return databaseDao.getBookmarkByUser(idUser);
    }

    public void insertBookmark(BookmarkEntity bookmarkEntity){
        databaseDao.insertToBookmark(bookmarkEntity);
    }

    public boolean checkBookmark(String idResep, String idUser){
        return databaseDao.checkBookmark(idResep, idUser);
    }

    public BookmarkEntity getItemBookmark(String idResep, String idUser){
        return databaseDao.getItemBookmark(idResep, idUser);
    }

    public void removeBookmark(int id){
        databaseDao.removeBookmarkById(id);
    }

    private class InsertBookmarkAsync extends AsyncTask<BookmarkEntity, Void, Void>{
        private DatabaseDao databaseDao;
        @Override
        protected Void doInBackground(BookmarkEntity... bookmarkEntities) {
            databaseDao.insertToBookmark(bookmarkEntities[0]);
            return null;
        }
    }

}
