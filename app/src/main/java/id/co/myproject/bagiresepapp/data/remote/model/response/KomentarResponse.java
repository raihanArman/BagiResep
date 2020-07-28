package id.co.myproject.bagiresepapp.data.remote.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.co.myproject.bagiresepapp.data.remote.model.Komentar;
import id.co.myproject.bagiresepapp.data.remote.model.User;

public class KomentarResponse {
    @SerializedName("value")
    @Expose
    private int value;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data_komentar")
    @Expose
    private List<Komentar> komentarList;

    public KomentarResponse(int value, String message, List<Komentar> komentarList) {
        this.value = value;
        this.message = message;
        this.komentarList = komentarList;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public List<Komentar> getKomentarList() {
        return komentarList;
    }
}
