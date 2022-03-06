package com.period.awareness;

import com.period.awareness.datamodels.CreatorData;
import com.period.awareness.datamodels.EntirePostModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RestApi {
    @GET("/posts/all")
    Call<EntirePostModel> getPostModel();

    @POST("/posts/create")
    Call<ResponseBody> createPost(@Body CreatorData creatorData);
}
