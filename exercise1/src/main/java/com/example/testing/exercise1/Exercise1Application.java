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
package com.example.testing.exercise1;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.testing.exercise1.component.ApplicationComponent;
import com.example.testing.exercise1.component.DaggerApplicationComponent;
import com.example.testing.exercise1.module.ApplicationModule;

public class Exercise1Application extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //1.Here we initialize our dependancy Graph
        //2.Note: Dagger generate a class (Dagger[ComponentName].class) that implements applicationComponent
        //3.Initialize applicationComponent using that class
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
