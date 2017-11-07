package com.ersaldyraisha.smartrash.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by A.I on 07/11/2017.
 */

public interface ApiInterface {

    @GET("api/trashdata")
    Call<CowResponseItem> getCow(@Query("X-Authorization") String apiKey);

}
