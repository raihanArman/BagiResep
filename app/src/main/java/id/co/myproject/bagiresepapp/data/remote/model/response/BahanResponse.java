package id.co.myproject.bagiresepapp.data.remote.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.co.myproject.bagiresepapp.data.remote.model.Bahan;
import id.co.myproject.bagiresepapp.data.remote.model.Steps;

public class BahanResponse {
    @SerializedName("value")
    @Expose
    private int value;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("bahan")
    @Expose
    private List<Bahan> bahanList;

    public BahanResponse(int value, String message, List<Bahan> bahanList) {
        this.value = value;
        this.message = message;
        this.bahanList = bahanList;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public List<Bahan> getBahanList() {
        return bahanList;
    }
}
