package com.ersaldyraisha.smartrash.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by A.I on 07/11/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "http://10.151.12.48/laravelLearning/laravelLearning/public/";
    //    public static final String BASE_URL = "http://192.168.1.62/karapan-api/karapan-api/public/";
//    public static final String API_KEY = "e36b1801d7b695e3f2c7ccaf8f4723b92b45352b";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
