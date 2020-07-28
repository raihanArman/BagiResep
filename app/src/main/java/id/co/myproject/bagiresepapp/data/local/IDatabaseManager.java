package id.co.myproject.bagiresepapp.data.local;

import java.util.List;

import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import io.reactivex.Observable;

public interface IDatabaseManager {
    Observable<List<BookmarkEntity>> getBookmarkById(String idUser);

    BookmarkEntity getItemBookmark(String idResep, String idUser);

    boolean checkBookmark(String idResep, String idUser);

    void insertToBookmark(BookmarkEntity bookmarkEntity);

    void removeById(int id);

    Observable<List<RencanaEntity>> getRencanaById(String idUser, String status);

    RencanaEntity getItemRencana(String idResep, String idUser);

    void updateRencana(String status, String idResep);

    boolean checkRencana(String idResep, String idUser);

    void insertToRencana(RencanaEntity rencanaEntity);

    void removeRencanaById(int id);

}
