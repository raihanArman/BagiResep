package id.co.myproject.bagiresepapp.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Komentar {
    @SerializedName("id_komentar")
    @Expose
    private int idKomentar;

    @SerializedName("id_resep")
    @Expose
    private String idResep;

    @SerializedName("id_user")
    @Expose
    private String idUser;

    @SerializedName("isi_komentar")
    @Expose
    private String isiKomentar;

    @SerializedName("timestamp")
    @Expose
    private Date timestamp;

    public Komentar() {
    }

    public Komentar(int idKomentar, String idResep, String idUser, String isiKomentar, Date timestamp) {
        this.idKomentar = idKomentar;
        this.idResep = idResep;
        this.idUser = idUser;
        this.isiKomentar = isiKomentar;
        this.timestamp = timestamp;
    }

    public int getIdKomentar() {
        return idKomentar;
    }

    public String getIdResep() {
        return idResep;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIsiKomentar() {
        return isiKomentar;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setIdKomentar(int idKomentar) {
        this.idKomentar = idKomentar;
    }

    public void setIdResep(String idResep) {
        this.idResep = idResep;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setIsiKomentar(String isiKomentar) {
        this.isiKomentar = isiKomentar;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
