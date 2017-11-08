package com.ersaldyraisha.smartrash.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by A.I on 07/11/2017.
 */

public class ResponseHTTP {

    @SerializedName("code")
    private String code;
    @SerializedName("status")
    private String status;
    @SerializedName("trash")
    private List<Trash> trashList;
    @SerializedName("distance")
    private List<Distance> distanceList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Distance> getDistanceList() {
        return distanceList;
    }

    public void setDistanceList(List<Distance> distanceList) {
        this.distanceList = distanceList;
    }

    public List<Trash> getTrashList() {
        return trashList;
    }

    public void setTrashList(List<Trash> trashList) {
        this.trashList = trashList;
    }
}
