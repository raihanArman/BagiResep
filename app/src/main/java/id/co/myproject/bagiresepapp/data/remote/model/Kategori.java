package id.co.myproject.bagiresepapp.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import id.co.myproject.bagiresepapp.BuildConfig;

public class Kategori {

    @SerializedName("id_kategori")
    @Expose
    private String id_kategori;

    @SerializedName("nama_kategori")
    @Expose
    private String nama_kategori;

    @SerializedName("gambar")
    @Expose
    private String gambar;


    public Kategori(String id_kategori, String nama_kategori, String gambar) {
        this.id_kategori = id_kategori;
        this.nama_kategori = nama_kategori;
        this.gambar = gambar;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getGambar() {
        String url = BuildConfig.BASE_URL_GAMBAR+"kategori/";
        return url+gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
