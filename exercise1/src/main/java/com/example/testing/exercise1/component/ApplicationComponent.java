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
package com.example.testing.exercise1.component;

import com.example.testing.exercise1.MainActivity;
import com.example.testing.exercise1.module.ApplicationModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class }) //This is where we are taking the dependancies
public interface ApplicationComponent {
    void inject(MainActivity mainActivity); // Here is where we want to inject (what parts of the dependancy graph are public)
}
