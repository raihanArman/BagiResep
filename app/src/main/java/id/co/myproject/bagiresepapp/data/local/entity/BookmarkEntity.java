package id.co.myproject.bagiresepapp.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_bookmark")
public class BookmarkEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "id_resep")
    private String idResep;

    @ColumnInfo(name = "id_user")
    private String idUser;

    @ColumnInfo(name = "title_resep")
    private String titleResep;

    @ColumnInfo(name = "poster_resep")
    private String posterResep;

    public BookmarkEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdResep() {
        return idResep;
    }

    public void setIdResep(String idResep) {
        this.idResep = idResep;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTitleResep() {
        return titleResep;
    }

    public void setTitleResep(String titleResep) {
        this.titleResep = titleResep;
    }

    public String getPosterResep() {
        return posterResep;
    }

    public void setPosterResep(String posterResep) {
        this.posterResep = posterResep;
    }
}
