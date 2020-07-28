package id.co.myproject.bagiresepapp.data.local;

import java.util.List;

import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import io.reactivex.Observable;

public class DatabaseManager implements IDatabaseManager{

    private final AppDatabase appDatabase;

    public DatabaseManager(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }


    @Override
    public Observable<List<BookmarkEntity>> getBookmarkById(String idUser) {
        return this.appDatabase.databaseDao().getBookmarkByUser(idUser);
    }

    @Override
    public BookmarkEntity getItemBookmark(String idResep, String idUser) {
        return this.appDatabase.databaseDao().getItemBookmark(idResep, idUser);
    }

    @Override
    public boolean checkBookmark(String idResep, String idUser) {
        boolean count = this.appDatabase.databaseDao().checkBookmark(idResep, idUser);
        return count;
    }

    @Override
    public void insertToBookmark(BookmarkEntity bookmarkEntity) {
        this.appDatabase.databaseDao().insertToBookmark(bookmarkEntity);
    }

    @Override
    public void removeById(int id) {
        this.appDatabase.databaseDao().removeBookmarkById(id);
    }

    @Override
    public Observable<List<RencanaEntity>> getRencanaById(String idUser, String status) {
        return this.appDatabase.databaseDao().getRencanaByUser(idUser, status);
    }

    @Override
    public RencanaEntity getItemRencana(String idResep, String idUser) {
        return this.appDatabase.databaseDao().getItemRencana(idResep, idUser);
    }

    @Override
    public void updateRencana(String status, String idResep) {
        this.appDatabase.databaseDao().updateStatusRencana(status, idResep);
    }

    @Override
    public boolean checkRencana(String idResep, String idUser) {
        return this.appDatabase.databaseDao().checkRencana(idResep, idUser);
    }

    @Override
    public void insertToRencana(RencanaEntity rencanaEntity) {
        this.appDatabase.databaseDao().insertToRencana(rencanaEntity);
    }

    @Override
    public void removeRencanaById(int id) {
        this.appDatabase.databaseDao().removeRencanaById(id);
    }
}
