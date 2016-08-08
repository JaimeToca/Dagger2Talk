package com.example.testing.jimydaggerkatas.ui.module;
import com.example.testing.jimydaggerkatas.repository.ActorsNetController;
import com.example.testing.jimydaggerkatas.ui.LoginActivity;
import com.example.testing.jimydaggerkatas.ui.presenter.GetActorsPresenter;

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
