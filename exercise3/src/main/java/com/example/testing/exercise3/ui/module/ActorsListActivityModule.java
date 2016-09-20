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
