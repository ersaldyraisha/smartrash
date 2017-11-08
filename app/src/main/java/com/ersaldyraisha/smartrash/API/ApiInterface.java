package com.ersaldyraisha.smartrash.API;

import com.ersaldyraisha.smartrash.Model.ResponseHTTP;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by A.I on 07/11/2017.
 */

public interface ApiInterface {

    @GET("api/trashdata")
    Call<ResponseHTTP> getTrash();

}
