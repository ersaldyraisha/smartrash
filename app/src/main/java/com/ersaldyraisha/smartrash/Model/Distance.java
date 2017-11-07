package com.ersaldyraisha.smartrash.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by A.I on 07/11/2017.
 */

public class Distance {

    @SerializedName("id")
    private String id;
    @SerializedName("trash_id")
    private String trash_id;
    @SerializedName("distance")
    private String distance;
    @SerializedName("status")
    private String status;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public String getDistanceId() {
        return id;
    }

    public void setDistanceId(String id) {
        this.id = id;
    }

    public String getTrash_id() {
        return trash_id;
    }

    public void setTrash_id(String trash_id) {
        this.trash_id = trash_id;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
