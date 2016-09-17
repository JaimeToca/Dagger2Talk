package com.example.testing.jimydaggerkatas.repository;

import com.example.testing.jimydaggerkatas.repository.model.ActorsWrapper;

public interface GetActorsCallback {
    void onSuccess(ActorsWrapper actorsWrapper);
    void onError(String error);
}
