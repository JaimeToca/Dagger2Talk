package com.example.testing.exercise1.component;

import com.example.testing.exercise1.MainActivity;
import com.example.testing.exercise1.module.ApplicationModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class }) //This is where we are taking the dependancies
public interface ApplicationComponent {
    void inject(MainActivity mainActivity); // Here is where we want to inject (what parts of the dependancy graph are public)
}
