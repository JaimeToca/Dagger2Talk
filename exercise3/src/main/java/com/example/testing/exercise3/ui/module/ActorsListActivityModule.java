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
package com.example.testing.exercise3.ui.module;

import com.example.testing.exercise3.ActorsListActivity;
import com.example.testing.exercise3.repository.ActorsNetController;
import com.example.testing.exercise3.ui.presenter.GetActorsPresenter;
import com.example.testing.exercise3.ui.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActorsListActivityModule {

    ActorsListActivity actorsListActivity;

    public ActorsListActivityModule(ActorsListActivity actorsListActivity){
        this.actorsListActivity = actorsListActivity;
    }

    @Provides
    @ActivityScope
    public ActorsListActivity provideLoginActivity(){
        return actorsListActivity;
    }

    @Provides
    @ActivityScope
    public GetActorsPresenter provideLoginPresenter(ActorsListActivity actorsListActivity, ActorsNetController user){
        return new GetActorsPresenter(actorsListActivity, user);
    }
}
