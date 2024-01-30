package com.example.newsapp;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<ArrayList<Articles>> getAllNews(@Url String url);

    @GET
    Call<ArrayList<Articles>>getNewsByCategory(@Url String url);


}
