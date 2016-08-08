package com.example.testing.exercise3.repository;

import com.example.testing.exercise3.repository.api.ActorsApiModule;
import com.example.testing.exercise3.repository.api.ActorsApiService;
import com.example.testing.exercise3.repository.model.ActorsWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActorsNetController {

    ActorsApiService actorsApiService;

    public ActorsNetController(ActorsApiService actorsApiService){
        this.actorsApiService = actorsApiService;
    }

    public void getActors(final GetActorsCallback callback){
        actorsApiService.getPopularActors(ActorsApiModule.API_KEY).enqueue(new Callback<ActorsWrapper>() {
            @Override
            public void onResponse(Call<ActorsWrapper> call, Response<ActorsWrapper> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ActorsWrapper> call, Throwable t) {
                callback.onError(call.toString());
            }
        });
    }
}
