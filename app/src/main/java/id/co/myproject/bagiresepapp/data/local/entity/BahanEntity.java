package id.co.myproject.bagiresepapp.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_bahan")
public class BahanEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "bahan")
    private String bahan;

    public BahanEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }
}
