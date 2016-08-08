package com.example.testing.jimydaggerkatas.ui.presenter;

import com.example.testing.jimydaggerkatas.repository.ActorsNetController;
import com.example.testing.jimydaggerkatas.repository.GetActorsCallback;
import com.example.testing.jimydaggerkatas.repository.model.Actor;
import com.example.testing.jimydaggerkatas.repository.model.ActorsWrapper;
import com.example.testing.jimydaggerkatas.ui.LoginActivity;

import javax.inject.Inject;

public class GetActorsPresenter {

    LoginActivity loginActivity;
    ActorsNetController actorsNetController;

    public GetActorsPresenter(LoginActivity loginActivity, ActorsNetController actorsNetController){
        this.loginActivity = loginActivity;
        this.actorsNetController = actorsNetController;
    }

    public void getActors(){
        loginActivity.showLoading();
        actorsNetController.getActors(new GetActorsCallback() {
            @Override
            public void onSuccess(ActorsWrapper actorsWrapper) {
                loginActivity.hideLoading();
                String actorsFormatted = formatActorsWrapperToShowOnUI(actorsWrapper);
                loginActivity.showActors(actorsFormatted);
            }

            @Override
            public void onError(String error) {
                loginActivity.hideLoading();
            }
        });
    }

    private String formatActorsWrapperToShowOnUI(ActorsWrapper actorsWrapper){
        String actors = "";
        for (Actor actor : actorsWrapper.getResults()) {
            actors = actors + "\n" + actor.getName() + "\n";
        }
        return actors;
    }
}
