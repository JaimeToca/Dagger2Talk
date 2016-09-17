package com.example.testing.jimydaggerkatas.ui.component;
import com.example.testing.jimydaggerkatas.repository.api.ActorsApiModule;
import com.example.testing.jimydaggerkatas.ui.ActorsListActivity;
import com.example.testing.jimydaggerkatas.ui.module.ActorsListActivityModule;

import dagger.Component;

//1.Indicate where we are taking dependencies. Check out ActorsListActivityModule.class
//Be aware that the presenter needs a network controller.
@Component(modules = {ActorsListActivityModule.class, ActorsApiModule.class})
public interface ActorsListActivityComponent {
    void inject(ActorsListActivity actorsListActivity);
}
