package com.example.testing.exercise3.ui.component;

import com.example.testing.exercise3.LoginActivity;
import com.example.testing.exercise3.ui.module.LoginActivityModule;
import com.example.testing.exercise3.ui.scope.ActivityScope;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {LoginActivityModule.class})
public interface LoginActivityComponent {
    void inject(LoginActivity loginActivity);
}
