package id.co.myproject.bagiresepapp.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_gambar_bahan")
public class BahanGambarEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "id_bahan")
    private int idBahan;

    @ColumnInfo(name = "gambar")
    private String gambar;

    public BahanGambarEntity() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBahan() {
        return idBahan;
    }

    public void setIdBahan(int idBahan) {
        this.idBahan = idBahan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
