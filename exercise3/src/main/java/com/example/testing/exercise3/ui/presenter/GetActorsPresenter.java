package com.example.testing.exercise3.ui.presenter;

import com.example.testing.exercise3.ActorsListActivity;
import com.example.testing.exercise3.repository.ActorsNetController;
import com.example.testing.exercise3.repository.GetActorsCallback;
import com.example.testing.exercise3.repository.model.Actor;
import com.example.testing.exercise3.repository.model.ActorsWrapper;

public class GetActorsPresenter {
    ActorsListActivity actorsListActivity;
    ActorsNetController actorsNetController;

    public GetActorsPresenter(ActorsListActivity actorsListActivity, ActorsNetController actorsNetController){
        this.actorsListActivity = actorsListActivity;
        this.actorsNetController = actorsNetController;
    }

    public void getActors(){
        actorsListActivity.showLoading();
        actorsNetController.getActors(new GetActorsCallback() {
            @Override
            public void onSuccess(ActorsWrapper actorsWrapper) {
                actorsListActivity.hideLoading();
                String actorsFormatted = formatActorsWrapperToShowOnUI(actorsWrapper);
                actorsListActivity.showActors(actorsFormatted);
            }

            @Override
            public void onError(String error) {
                actorsListActivity.hideLoading();
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
