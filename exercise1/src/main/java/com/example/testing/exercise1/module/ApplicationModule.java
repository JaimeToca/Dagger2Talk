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
package com.example.testing.exercise1.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule (Application application){
        this.application = application;
    }

    @Singleton @Provides
    public Context provideContext(){
        return application;
    }

    //2. We want sharePreferences instance tied to the application lifecycle and
    //available to all our activities and fragments.

    //3.Provide sharePreferences using PreferencesManager.getDefaultSharedPreferences
    @Provides @Singleton
    public SharedPreferences provideSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
