package com.example.testing.exercise1;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.testing.exercise1.component.ApplicationComponent;
import com.example.testing.exercise1.component.DaggerApplicationComponent;
import com.example.testing.exercise1.module.ApplicationModule;

public class Exercise1Application extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //Here we create the dependancy Graph and connect everything together using a component
        applicationComponent = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
