package com.example.testing.jimydaggerkatas.ui.component;
import com.example.testing.jimydaggerkatas.repository.api.ActorsApiModule;
import com.example.testing.jimydaggerkatas.ui.LoginActivity;
import com.example.testing.jimydaggerkatas.ui.module.LoginActivityModule;

import dagger.Component;

@Component(modules = {LoginActivityModule.class, ActorsApiModule.class})
public interface LoginActivityComponent {
    void inject(LoginActivity loginActivity);
}
