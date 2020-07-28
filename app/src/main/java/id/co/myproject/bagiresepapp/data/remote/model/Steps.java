package id.co.myproject.bagiresepapp.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Steps {
    @SerializedName("id_steps")
    @Expose
    private String idSteps;

    @SerializedName("id_resep")
    @Expose
    private String idResep;

    @SerializedName("langkah")
    @Expose
    private String langkah;

    @SerializedName("ket")
    @Expose
    private String ket;

    public Steps() {
    }

    public Steps(String idSteps, String idResep, String langkah, String ket) {
        this.idSteps = idSteps;
        this.idResep = idResep;
        this.langkah = langkah;
        this.ket = ket;
    }

    public String getIdSteps() {
        return idSteps;
    }

    public String getIdResep() {
        return idResep;
    }

    public String getLangkah() {
        return langkah;
    }

    public String getKet() {
        return ket;
    }

    public void setIdSteps(String idSteps) {
        this.idSteps = idSteps;
    }

    public void setIdResep(String idResep) {
        this.idResep = idResep;
    }

    public void setLangkah(String langkah) {
        this.langkah = langkah;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }
}
