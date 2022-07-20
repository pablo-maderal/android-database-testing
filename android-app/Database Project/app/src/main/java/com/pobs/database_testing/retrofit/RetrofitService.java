package com.pobs.database_testing.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit;

    public RetrofitService() {
        initalizeRetrofit();
    }

    private void initalizeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://xxx.xx.xx.x:9000")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
