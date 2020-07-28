package id.co.myproject.bagiresepapp.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_gambar_langkah")
public class LangkahGambarEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "id_langkah")
    private int idLangkah;

    @ColumnInfo(name = "gambar")
    private String gambar;

    public LangkahGambarEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLangkah() {
        return idLangkah;
    }

    public void setIdLangkah(int idLangkah) {
        this.idLangkah = idLangkah;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
