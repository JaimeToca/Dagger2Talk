package com.example.testing.jimydaggerkatas.repository.api;

import com.example.testing.jimydaggerkatas.repository.model.ActorsWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ActorsApiService {
    @GET("/3/person/popular")
    Call<ActorsWrapper> getPopularActors(@Query("api_key") String apiKey);
}
