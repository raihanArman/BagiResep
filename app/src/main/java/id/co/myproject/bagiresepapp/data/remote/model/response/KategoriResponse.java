package id.co.myproject.bagiresepapp.data.remote.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.co.myproject.bagiresepapp.data.remote.model.Kategori;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;

public class KategoriResponse {
    @SerializedName("value")
    @Expose
    private int value;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("kategori")
    @Expose
    private List<Kategori> kategoriList;

    public KategoriResponse(int value, String message, List<Kategori> kategoriList) {
        this.value = value;
        this.message = message;
        this.kategoriList = kategoriList;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public List<Kategori> getKategoriList() {
        return kategoriList;
    }
}
