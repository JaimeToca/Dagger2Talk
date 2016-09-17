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
package com.example.testing.jimydaggerkatas.ui.presenter;

import com.example.testing.jimydaggerkatas.repository.ActorsNetController;
import com.example.testing.jimydaggerkatas.repository.GetActorsCallback;
import com.example.testing.jimydaggerkatas.repository.model.Actor;
import com.example.testing.jimydaggerkatas.repository.model.ActorsWrapper;
import com.example.testing.jimydaggerkatas.ui.ActorsListActivity;

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
