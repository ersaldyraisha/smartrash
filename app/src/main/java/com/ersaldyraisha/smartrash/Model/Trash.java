package com.ersaldyraisha.smartrash.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by A.I on 07/11/2017.
 */

public class Trash {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("color")
    private String color;
    @SerializedName("address")
    private String address;

    public String getTrashId() {
        return id;
    }

    public void setTrashId(String id) {
        this.id = id;
    }

    public String getTrashName() {
        return name;
    }

    public void setTrashName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
