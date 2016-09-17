package com.example.testing.exercise3;

import com.example.testing.exercise3.repository.api.ActorsApiModule;
import com.example.testing.exercise3.ui.component.ActorsListActivityComponent;
import com.example.testing.exercise3.ui.module.ActorsListActivityModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, ActorsApiModule.class})
public interface ApplicationComponent {
    //1. ApplicationComponent will be root for ActorListActivityComponent. Use plus method
    ActorsListActivityComponent plus(ActorsListActivityModule actorsListActivityModule);
}
