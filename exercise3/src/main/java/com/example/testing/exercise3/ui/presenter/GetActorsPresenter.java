package com.example.testing.exercise3.ui.presenter;

import com.example.testing.exercise3.LoginActivity;
import com.example.testing.exercise3.repository.ActorsNetController;
import com.example.testing.exercise3.repository.GetActorsCallback;
import com.example.testing.exercise3.repository.model.Actor;
import com.example.testing.exercise3.repository.model.ActorsWrapper;

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
