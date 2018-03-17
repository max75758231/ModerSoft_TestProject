package com.example.maxzonov.modersoft_testproject.retrofit;

import com.example.maxzonov.modersoft_testproject.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("home/info/")
    Call<ResponseData> getJson(@Field("city_id") String cityId);
}
