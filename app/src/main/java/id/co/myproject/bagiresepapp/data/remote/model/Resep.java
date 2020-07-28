package id.co.myproject.bagiresepapp.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import id.co.myproject.bagiresepapp.BuildConfig;

public class Resep implements Parcelable {
    @SerializedName("id_resep")
    @Expose
    private String id;

    @SerializedName("id_kategori")
    @Expose
    private String id_kategori;

    @SerializedName("nama_resep")
    @Expose
    private String resep;

    @SerializedName("deskripsi")
    @Expose
    private String deksripsi;

    @SerializedName("gambar")
    @Expose
    private String gambar;

    @SerializedName("nama_kategori")
    @Expose
    private String nama_kategori;

    @SerializedName("id_user")
    @Expose
    private String id_user;

    @SerializedName("nama_user")
    @Expose
    private String nama_user;

    @SerializedName("gambar_user")
    @Expose
    private String gambar_user;

    @SerializedName("jumlah_komentar")
    @Expose
    private String jumKomentar;

    @SerializedName("jumlah_like")
    @Expose
    private String jumLike;

    @SerializedName("total_rating")
    @Expose
    private String totalRating;

    @SerializedName("total_user_rating")
    @Expose
    private String totalUserRating;

    @SerializedName("waktu_masak")
    @Expose
    private String waktuMasak;

    @SerializedName("total_steps")
    @Expose
    private String totalSteps;

    @SerializedName("total_bahan")
    @Expose
    private String totalBahan;

    public Resep() {
    }

    public Resep(String id, String id_kategori, String resep, String deksripsi, String gambar, String nama_kategori, String id_user, String nama_user, String gambar_user, String jumKomentar, String jumLike, String totalRating, String totalUserRating, String waktuMasak, String totalSteps, String totalBahan) {
        this.id = id;
        this.id_kategori = id_kategori;
        this.resep = resep;
        this.deksripsi = deksripsi;
        this.gambar = gambar;
        this.nama_kategori = nama_kategori;
        this.id_user = id_user;
        this.nama_user = nama_user;
        this.gambar_user = gambar_user;
        this.jumKomentar = jumKomentar;
        this.jumLike = jumLike;
        this.totalRating = totalRating;
        this.totalUserRating = totalUserRating;
        this.waktuMasak = waktuMasak;
        this.totalSteps = totalSteps;
        this.totalBahan = totalBahan;
    }

    public String getId() {
        return id;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public String getResep() {
        return resep;
    }

    public String getDeksripsi() {
        return deksripsi;
    }

    public String getGambar() {
        String url = BuildConfig.BASE_URL_GAMBAR;
        return url+gambar;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public String getId_user() {
        return id_user;
    }

    public String getNama_user() {
        return nama_user;
    }

    public String getGambar_user() {
        String url = BuildConfig.BASE_URL_GAMBAR+"user/";
        return url+gambar_user;
    }

    public String getJumKomentar() {
        return jumKomentar;
    }

    public String getJumLike() {
        return jumLike;
    }

    public String getTotalRating() {
        return totalRating;
    }

    public String getTotalUserRating() {
        return totalUserRating;
    }

    public String getWaktuMasak() {
        return waktuMasak;
    }

    public String getTotalSteps() {
        return totalSteps;
    }

    public String getTotalBahan() {
        return totalBahan;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public void setResep(String resep) {
        this.resep = resep;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public void setGambar_user(String gambar_user) {
        this.gambar_user = gambar_user;
    }

    public void setJumKomentar(String jumKomentar) {
        this.jumKomentar = jumKomentar;
    }

    public void setJumLike(String jumLike) {
        this.jumLike = jumLike;
    }

    public void setTotalRating(String totalRating) {
        this.totalRating = totalRating;
    }

    public void setTotalUserRating(String totalUserRating) {
        this.totalUserRating = totalUserRating;
    }

    public void setWaktuMasak(String waktuMasak) {
        this.waktuMasak = waktuMasak;
    }

    public void setTotalSteps(String totalSteps) {
        this.totalSteps = totalSteps;
    }

    public void setTotalBahan(String totalBahan) {
        this.totalBahan = totalBahan;
    }

    public Resep(String id, String id_user) {
        this.id = id;
        this.id_user = id_user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.id_kategori);
        dest.writeString(this.resep);
        dest.writeString(this.deksripsi);
        dest.writeString(this.gambar);
        dest.writeString(this.nama_kategori);
        dest.writeString(this.id_user);
        dest.writeString(this.nama_user);
        dest.writeString(this.gambar_user);
        dest.writeString(this.jumKomentar);
        dest.writeString(this.jumLike);
        dest.writeString(this.totalRating);
        dest.writeString(this.totalUserRating);
        dest.writeString(this.waktuMasak);
        dest.writeString(this.totalSteps);
        dest.writeString(this.totalBahan);
    }

    protected Resep(Parcel in) {
        this.id = in.readString();
        this.id_kategori = in.readString();
        this.resep = in.readString();
        this.deksripsi = in.readString();
        this.gambar = in.readString();
        this.nama_kategori = in.readString();
        this.id_user = in.readString();
        this.nama_user = in.readString();
        this.gambar_user = in.readString();
        this.jumKomentar = in.readString();
        this.jumLike = in.readString();
        this.totalRating = in.readString();
        this.totalUserRating = in.readString();
        this.waktuMasak = in.readString();
        this.totalSteps = in.readString();
        this.totalBahan = in.readString();
    }

    public static final Creator<Resep> CREATOR = new Creator<Resep>() {
        @Override
        public Resep createFromParcel(Parcel source) {
            return new Resep(source);
        }

        @Override
        public Resep[] newArray(int size) {
            return new Resep[size];
        }
    };
}
