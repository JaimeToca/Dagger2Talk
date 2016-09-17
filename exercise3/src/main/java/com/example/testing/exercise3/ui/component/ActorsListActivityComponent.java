package com.example.testing.exercise3.ui.component;

import com.example.testing.exercise3.ActorsListActivity;
import com.example.testing.exercise3.ui.module.ActorsListActivityModule;
import com.example.testing.exercise3.ui.scope.ActivityScope;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActorsListActivityModule.class})
public interface ActorsListActivityComponent {
    void inject(ActorsListActivity actorsListActivity);
}
