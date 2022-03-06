package com.period.awareness;

import com.period.awareness.datamodels.NgoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("ngos/getngo?loc=Mumbai")
    Call<NgoModel> getNgoList();



}
