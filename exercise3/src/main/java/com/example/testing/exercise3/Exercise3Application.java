/*
 * Copyright (C) 2016 Jaime Toca Muñoz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.testing.exercise3;

import android.app.Application;
import com.example.testing.exercise3.repository.api.ActorsApiModule;
import com.example.testing.exercise3.ui.component.ActorsListActivityComponent;

public class Exercise3Application extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationGraph();
    }

    private void initApplicationGraph(){
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .actorsApiModule(new ActorsApiModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
