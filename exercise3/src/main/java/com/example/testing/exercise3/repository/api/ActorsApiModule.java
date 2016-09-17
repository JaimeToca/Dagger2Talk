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
package com.example.testing.exercise3.repository.api;

import com.example.testing.exercise3.repository.ActorsNetController;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ActorsApiModule {

    private static final String ACTORS_ENDPOINT = "http://api.themoviedb.org/";
    public static final String API_KEY = "ef7207d60c949efbe23d1d2c0d580eb2";

    @Provides @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.addInterceptor(logging);
        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        return builder.build();
    }

    @Provides @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl(ACTORS_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    @Provides @Singleton
    public ActorsApiService provideActorsApiService(Retrofit retrofitAdapater){
        return retrofitAdapater.create(ActorsApiService.class);
    }

    @Provides @Singleton
    public ActorsNetController provideUserNetController(ActorsApiService actorsApiService){
        return new ActorsNetController(actorsApiService);
    }
}
