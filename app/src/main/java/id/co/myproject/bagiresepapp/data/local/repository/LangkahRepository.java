package id.co.myproject.bagiresepapp.data.local.repository;

import android.app.Application;

import java.util.List;

import id.co.myproject.bagiresepapp.data.local.AppDatabase;
import id.co.myproject.bagiresepapp.data.local.dao.DatabaseDao;
import id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity;
import io.reactivex.Observable;
import io.reactivex.Single;

public class LangkahRepository {
    private DatabaseDao databaseDao;

    public LangkahRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getAppDatabase(application);
        databaseDao = appDatabase.databaseDao();
    }

    public Single<List<LangkahEntity>> getLangkahList(){
        return databaseDao.getLangkah();
    }

    public void insertToLangkah(LangkahEntity langkahEntity){
        databaseDao.insertLangkah(langkahEntity);
    }

    public void updateLangkah(int idLangkah, String langkah){
        databaseDao.updateLangkah(idLangkah, langkah);
    }

    public void removeLangkahById(int idLangkah){
        databaseDao.removeLangkahById(idLangkah);
    }

    public void removeAllLangkah(){
        databaseDao.removeAllLangkah();
    }


    //    LangkahGambar
    public List<LangkahGambarEntity> getLangkahGambar(int idLangkah){
        return databaseDao.getLangkahGambar(idLangkah);
    }

    public void insertLangkahGambar(LangkahGambarEntity langkahGambarEntity){
        databaseDao.insertlangkahGambar(langkahGambarEntity);
    }

    public void removeLangkahGambarById(int idGambar){
        databaseDao.removeLangkahGambarById(idGambar);
    }

    public void removeLangkahGambarByIdLangkah(int idLangkah){
        databaseDao.removeLangkahGambarByIdLangkah(idLangkah);
    }
}
