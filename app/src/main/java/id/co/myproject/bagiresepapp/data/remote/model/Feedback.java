package id.co.myproject.bagiresepapp.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feedback {
    @SerializedName("id_rating")
    @Expose
    private String idRating;

    @SerializedName("id_resep")
    @Expose
    private String idResep;

    @SerializedName("id_user")
    @Expose
    private String idUser;

    @SerializedName("rating")
    @Expose
    private String rating;

    @SerializedName("masukan")
    @Expose
    private String masukan;

    public Feedback() {
    }

    public String getIdRating() {
        return idRating;
    }

    public String getIdResep() {
        return idResep;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getRating() {
        return rating;
    }

    public String getMasukan() {
        return masukan;
    }


    public void setIdRating(String idRating) {
        this.idRating = idRating;
    }

    public void setIdResep(String idResep) {
        this.idResep = idResep;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setMasukan(String masukan) {
        this.masukan = masukan;
    }
}
