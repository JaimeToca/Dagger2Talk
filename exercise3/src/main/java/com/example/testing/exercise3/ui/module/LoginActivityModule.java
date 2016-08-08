package com.example.testing.exercise3.ui.module;

import com.example.testing.exercise3.LoginActivity;
import com.example.testing.exercise3.repository.ActorsNetController;
import com.example.testing.exercise3.ui.presenter.GetActorsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    LoginActivity loginActivity;

    public LoginActivityModule(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
    }

    @Provides
    public LoginActivity provideLoginActivity(){
        return loginActivity;
    }

    @Provides
    public GetActorsPresenter provideLoginPresenter(LoginActivity loginActivity, ActorsNetController user){
        return new GetActorsPresenter(loginActivity, user);
    }
}
