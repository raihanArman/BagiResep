package id.co.myproject.bagiresepapp.data.remote.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.co.myproject.bagiresepapp.data.remote.model.Steps;
import id.co.myproject.bagiresepapp.data.remote.model.User;

public class StepsResponse {
    @SerializedName("value")
    @Expose
    private int value;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("steps")
    @Expose
    private List<Steps> stepsList;

    public StepsResponse(int value, String message, List<Steps> stepsList) {
        this.value = value;
        this.message = message;
        this.stepsList = stepsList;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public List<Steps> getStepsList() {
        return stepsList;
    }
}
