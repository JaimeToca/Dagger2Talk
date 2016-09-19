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
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mPreferences;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        initDependacy();
    }

    private void bindViews(){
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    private void initDependacy(){
        ((Exercise1Application)getApplication()).getApplicationComponent().inject(this);
    }

    @Override
    protected void onResume(){
        super.onResume();

        if (mPreferences != null){
            String done = "AWESOME, Exercise 1 DONE ;)";
            tvResult.setText(done);
        } else {
            String failed = "You failed :( , keep trying !";
            tvResult.setText(failed);
        }
    }
}
