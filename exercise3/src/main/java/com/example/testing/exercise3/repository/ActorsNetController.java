/*
 * Copyright (C) 2016 Jaime Toca Muñoz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
