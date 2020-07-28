package id.co.myproject.bagiresepapp.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bahan {
    @SerializedName("id_bahan")
    @Expose
    private String idBahan;

    @SerializedName("id_resep")
    @Expose
    private String idResep;

    @SerializedName("bahan")
    @Expose
    private String bahan;

    @SerializedName("ket")
    @Expose
    private String ket;

    public Bahan() {
    }

    public Bahan(String idBahan, String idResep, String bahan, String ket) {
        this.idBahan = idBahan;
        this.idResep = idResep;
        this.bahan = bahan;
        this.ket = ket;
    }

    public String getIdBahan() {
        return idBahan;
    }

    public String getIdResep() {
        return idResep;
    }

    public String getBahan() {
        return bahan;
    }

    public String getKet() {
        return ket;
    }

    public void setIdBahan(String idBahan) {
        this.idBahan = idBahan;
    }

    public void setIdResep(String idResep) {
        this.idResep = idResep;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }
}
