package id.co.myproject.bagiresepapp.data.local.repository;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import id.co.myproject.bagiresepapp.data.local.AppDatabase;
import id.co.myproject.bagiresepapp.data.local.dao.DatabaseDao;
import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import io.reactivex.Observable;

public class RencanaRepository {
    private DatabaseDao databaseDao;

    public RencanaRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getAppDatabase(application);
        databaseDao = appDatabase.databaseDao();
    }

    public Observable<List<RencanaEntity>> getRencana(String idUser, String status){
        return databaseDao.getRencanaByUser(idUser, status);
    }

    public void updateRencana(String status, String idResep){
        databaseDao.updateStatusRencana(status, idResep);
    }

    public void insertRencana(RencanaEntity rencanaEntity){
        databaseDao.insertToRencana(rencanaEntity);
    }

    public boolean checkRencana(String idResep, String idUser){
        return databaseDao.checkRencana(idResep, idUser);
    }

    public RencanaEntity getItemRencana(String idResep, String idUser){
        return databaseDao.getItemRencana(idResep, idUser);
    }

    public void removeRencana(int id){
        databaseDao.removeRencanaById(id);
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
