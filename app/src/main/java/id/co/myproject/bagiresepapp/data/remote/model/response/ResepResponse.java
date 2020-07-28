package id.co.myproject.bagiresepapp.data.remote.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.User;

public class ResepResponse {
    @SerializedName("value")
    @Expose
    private int value;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("resep")
    @Expose
    private List<Resep> resepList;

    public ResepResponse(int value, String message, List<Resep> resepList) {
        this.value = value;
        this.message = message;
        this.resepList = resepList;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public List<Resep> getResepList() {
        return resepList;
    }
}
