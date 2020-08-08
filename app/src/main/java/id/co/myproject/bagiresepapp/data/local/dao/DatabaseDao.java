package id.co.myproject.bagiresepapp.data.local.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import id.co.myproject.bagiresepapp.data.local.entity.BahanEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface DatabaseDao {
    @Query("SELECT * FROM tb_bookmark WHERE id_user = :idUser")
    Observable<List<BookmarkEntity>> getBookmarkByUser(String idUser);

    @Query("SELECT * FROM tb_bookmark WHERE id_resep = :idResep AND id_user = :idUser")
    boolean checkBookmark(String idResep, String idUser);

    @Query("SELECT * FROM tb_bookmark WHERE id_resep = :idResep AND id_user = :idUser")
    BookmarkEntity getItemBookmark(String idResep, String idUser);

    @Insert
    void insertToBookmark(BookmarkEntity bookmarkEntity);

    @Query("DELETE FROM tb_bookmark WHERE id = :id")
    void removeBookmarkById(int id);

// Rencana

    @Query("SELECT * FROM tb_rencana WHERE id_user = :idUser AND status = :status")
    Observable<List<RencanaEntity>> getRencanaByUser(String idUser, String status);

    @Query("UPDATE tb_rencana SET status = :status WHERE id_resep = :idResep")
    void updateStatusRencana(String status, String idResep);

    @Query("SELECT * FROM tb_rencana WHERE id_resep = :idResep AND id_user = :idUser")
    boolean checkRencana(String idResep, String idUser);

    @Query("SELECT * FROM tb_rencana WHERE id_resep = :idResep AND id_user = :idUser")
    RencanaEntity getItemRencana(String idResep, String idUser);

    @Insert
    void insertToRencana(RencanaEntity rencanaEntity);

    @Query("DELETE FROM tb_rencana WHERE id = :id")
    void removeRencanaById(int id);

//    Bahan
    @Query("SELECT * FROM tb_bahan")
    List<BahanEntity> getBahan();

    @Query("UPDATE tb_bahan SET bahan = :bahan WHERE id = :idBahan")
    void updateBahan(int idBahan, String bahan);

    @Insert
    void insertToBahan(BahanEntity bahanEntity);

    @Query("DELETE FROM tb_bahan WHERE id = :idBahan")
    void removeBahanById(int idBahan);

    @Query("DELETE FROM tb_bahan")
    void removeAllBahan();

//    BahanGambar
    @Query("SELECT * FROM tb_gambar_bahan WHERE id_bahan = :idBahan")
    List<BahanGambarEntity> getBahanGambar(int idBahan);

    @Insert
    void insertToBahanGambar(BahanGambarEntity bahanGambarEntity);

    @Query("DELETE FROM tb_gambar_bahan WHERE id = :idGambar")
    void removeBahanGambarById(int idGambar);

    @Query("DELETE FROM tb_gambar_bahan WHERE id_bahan = :idBahan")
    void removeBahanGambarByIdBahan(int idBahan);

//    Langkah
    @Query("SELECT * FROM tb_langkah")
    List<LangkahEntity> getLangkah();

    @Query("UPDATE tb_langkah SET langkah = :langkah WHERE id = :idLangkah")
    void updateLangkah(int idLangkah, String langkah);

    @Insert
    void insertLangkah(LangkahEntity langkahEntity);

    @Query("DELETE FROM tb_langkah WHERE id = :idLangkah")
    void removeLangkahById(int idLangkah);

    @Query("DELETE FROM tb_langkah")
    void removeAllLangkah();


    //    LangkahGambar
    @Query("SELECT * FROM tb_gambar_langkah WHERE id_langkah = :idLangkah")
    List<LangkahGambarEntity> getLangkahGambar(int idLangkah);

    @Insert
    void insertlangkahGambar(LangkahGambarEntity langkahGambarEntity);

    @Query("DELETE FROM tb_gambar_langkah WHERE id = :idGambar")
    void removeLangkahGambarById(int idGambar);

    @Query("DELETE FROM tb_gambar_langkah WHERE id_langkah = :idLangkah")
    void removeLangkahGambarByIdLangkah(int idLangkah);

}
