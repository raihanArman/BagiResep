package id.co.myproject.bagiresepapp.data.local;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import id.co.myproject.bagiresepapp.data.local.dao.DatabaseDao;
import id.co.myproject.bagiresepapp.data.local.entity.BahanEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;

@Database(entities = {
        BookmarkEntity.class,
        RencanaEntity.class,
        BahanEntity.class,
        BahanGambarEntity.class,
        LangkahEntity.class,
        LangkahGambarEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();

    public static AppDatabase getAppDatabase(Application application){
        return Room.databaseBuilder(application, AppDatabase.class, "db_resep")
                .allowMainThreadQueries().build();
    }
}
