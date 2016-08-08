package com.example.testing.exercise3;

import com.example.testing.exercise3.repository.api.ActorsApiModule;
import com.example.testing.exercise3.ui.component.LoginActivityComponent;
import com.example.testing.exercise3.ui.module.LoginActivityModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, ActorsApiModule.class})
public interface ApplicationComponent {
    LoginActivityComponent plus(LoginActivityModule loginActivityModule);
}
