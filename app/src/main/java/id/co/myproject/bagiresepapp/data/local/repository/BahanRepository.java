package id.co.myproject.bagiresepapp.data.local.repository;

import android.app.Application;

import java.util.List;

import id.co.myproject.bagiresepapp.data.local.AppDatabase;
import id.co.myproject.bagiresepapp.data.local.dao.DatabaseDao;
import id.co.myproject.bagiresepapp.data.local.entity.BahanEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity;
import io.reactivex.Observable;
import io.reactivex.Single;

public class BahanRepository {
    private DatabaseDao databaseDao;

    public BahanRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getAppDatabase(application);
        databaseDao = appDatabase.databaseDao();
    }

    public Single<List<BahanEntity>> getBahanList(){
        return databaseDao.getBahan();
    }

    public void insertToBahan(BahanEntity bahanEntity){
        databaseDao.insertToBahan(bahanEntity);
    }

    public void updateBahan(int idBahan, String bahan){
        databaseDao.updateBahan(idBahan, bahan);
    }

    public void removeBahanById(int idBahan){
        databaseDao.removeBahanById(idBahan);
    }

    public void removeAllBahan(){
        databaseDao.removeAllBahan();
    }

//    BahanGambar
    public List<BahanGambarEntity> getBahanGambar(int idBahan){
        return databaseDao.getBahanGambar(idBahan);
    }

    public void insertBahanGambar(BahanGambarEntity bahanGambarEntity){
        databaseDao.insertToBahanGambar(bahanGambarEntity);
    }

    public void removeBahanGambarById(int idGambar){
        databaseDao.removeBahanGambarById(idGambar);
    }

    public void removeBahanGambarByIdBahan(int idBahan){
        databaseDao.removeBahanGambarByIdBahan(idBahan);
    }
}
