package com.pobs.database_testing.retrofit;

import com.pobs.database_testing.model.Poll;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PollApi {


    @POST("/poll/increment_a")
    Call<Poll> increment_a();

    @POST("/poll/increment_b")
    Call<Poll> increment_b();

    @POST("/poll/increment_c")
    Call<Poll> increment_c();

    @GET("/poll/testDB")
    Call<Poll> testConnection();
}
