package com.example.testing.exercise3.repository.api;

import com.example.testing.exercise3.repository.model.ActorsWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ActorsApiService {
    @GET("/3/person/popular")
    Call<ActorsWrapper> getPopularActors(@Query("api_key") String apiKey);
}
