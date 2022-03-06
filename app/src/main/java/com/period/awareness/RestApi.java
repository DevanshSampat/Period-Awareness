package com.period.awareness;

import com.period.awareness.datamodels.EntirePostModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/posts/all")
    Call<EntirePostModel> getPostModel();
}
