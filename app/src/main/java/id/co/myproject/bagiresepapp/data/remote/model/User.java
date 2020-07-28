package id.co.myproject.bagiresepapp.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import id.co.myproject.bagiresepapp.BuildConfig;

public class User {
    @SerializedName("id_user")
    @Expose
    private String id;

    @SerializedName("nama_user")
    @Expose
    private String nama;

    @SerializedName("email_user")
    @Expose
    private String email;

    @SerializedName("gambar")
    @Expose
    private String gambar;

    @SerializedName("jml_pengikut")
    @Expose
    private String jmlPengikut;

    @SerializedName("jml_mengikuti")
    @Expose
    private String jmlMengikuti;

    @SerializedName("jml_resep")
    @Expose
    private String jmlResep;

    public User() {
    }

    public User(String id, String nama, String email, String gambar, String jmlPengikut, String jmlMengikuti, String jmlResep) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.gambar = gambar;
        this.jmlPengikut = jmlPengikut;
        this.jmlMengikuti = jmlMengikuti;
        this.jmlResep = jmlResep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public String getNamaDepan(){
        String[] namaDepan = nama.split(" ");
        return namaDepan[0];
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGambar() {
        String url = BuildConfig.BASE_URL_GAMBAR+"user/";
        return url+gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getJmlPengikut() {
        return jmlPengikut;
    }

    public void setJmlPengikut(String jmlPengikut) {
        this.jmlPengikut = jmlPengikut;
    }

    public String getJmlMengikuti() {
        return jmlMengikuti;
    }

    public void setJmlMengikuti(String jmlMengikuti) {
        this.jmlMengikuti = jmlMengikuti;
    }

    public String getJmlResep() {
        return jmlResep;
    }

    public void setJmlResep(String jmlResep) {
        this.jmlResep = jmlResep;
    }
}
