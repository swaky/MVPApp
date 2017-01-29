package com.swanand.mvpdemo.api;

import com.swanand.mvpdemo.model.Questions;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by swanand on 1/28/2017.
 */

public interface ApiInterface {

    @GET("questions")
    Call<Questions> getQuestions(@QueryMap Map<String,String> params);
}
