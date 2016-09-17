package com.example.testing.jimydaggerkatas.ui.module;
import com.example.testing.jimydaggerkatas.repository.ActorsNetController;
import com.example.testing.jimydaggerkatas.ui.ActorsListActivity;
import com.example.testing.jimydaggerkatas.ui.presenter.GetActorsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActorsListActivityModule {

    ActorsListActivity actorsListActivity;

    public ActorsListActivityModule(ActorsListActivity actorsListActivity){
        this.actorsListActivity = actorsListActivity;
    }

    @Provides
    public ActorsListActivity provideLoginActivity(){
        return actorsListActivity;
    }

    @Provides
    public GetActorsPresenter provideLoginPresenter(ActorsListActivity actorsListActivity, ActorsNetController actorNetController){
        return new GetActorsPresenter(actorsListActivity, actorNetController);
    }
}
