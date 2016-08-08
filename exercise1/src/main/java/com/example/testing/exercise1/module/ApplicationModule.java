package com.example.testing.exercise1.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule (Application application){
        this.application = application;
    }

    @Singleton @Provides
    public Context provideContext(){
        return application;
    }

    //Provide sharePreferences using PreferencesManager.getDefaultSharedPreferences(context)
    @Provides @Singleton
    public SharedPreferences provideSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
