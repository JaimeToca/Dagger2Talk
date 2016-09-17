package com.example.testing.exercise3.repository;

import com.example.testing.exercise3.repository.model.ActorsWrapper;

public interface GetActorsCallback {
    void onSuccess(ActorsWrapper actorsWrapper);
    void onError(String error);
}
