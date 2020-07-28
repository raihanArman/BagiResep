package id.co.myproject.bagiresepapp.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_rencana")
public class RencanaEntity {
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

    @ColumnInfo(name = "status")
    private String status;

    public RencanaEntity() {
    }

    public int getId() {
        return id;
    }

    public String getIdResep() {
        return idResep;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getTitleResep() {
        return titleResep;
    }

    public String getPosterResep() {
        return posterResep;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdResep(String idResep) {
        this.idResep = idResep;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setTitleResep(String titleResep) {
        this.titleResep = titleResep;
    }

    public void setPosterResep(String posterResep) {
        this.posterResep = posterResep;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
