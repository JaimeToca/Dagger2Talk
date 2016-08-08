package com.example.testing.exercise3;

import android.app.Application;
import com.example.testing.exercise3.repository.api.ActorsApiModule;
import com.example.testing.exercise3.ui.component.LoginActivityComponent;

public class Exercise3Application extends Application {

    private ApplicationComponent applicationComponent;
    private LoginActivityComponent loginActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationGraph();
    }

    private void initApplicationGraph(){
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .actorsApiModule(new ActorsApiModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    public void releaseLoginActivityComponent(){
        loginActivityComponent = null;
    }
}
