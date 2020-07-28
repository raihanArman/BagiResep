package id.co.myproject.bagiresepapp.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_langkah")
public class LangkahEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "langkah")
    private String langkah;

    public LangkahEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLangkah() {
        return langkah;
    }

    public void setLangkah(String langkah) {
        this.langkah = langkah;
    }
}
