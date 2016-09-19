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
package com.example.testing.jimydaggerkatas.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.testing.jimydaggerkatas.R;
import com.example.testing.jimydaggerkatas.ui.component.ActorsListActivityComponent;
import com.example.testing.jimydaggerkatas.ui.component.DaggerActorsListActivityComponent;
import com.example.testing.jimydaggerkatas.ui.module.ActorsListActivityModule;
import com.example.testing.jimydaggerkatas.ui.presenter.GetActorsPresenter;
import javax.inject.Inject;

public class ActorsListActivity extends AppCompatActivity {

    private static String DAGGER_LOG = "Dagger";

    private ProgressBar mPbLoading;
    private Button mButtonGetActors;
    private TextView mTvActorList;
    @Inject GetActorsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        initDaggerLoginActivityGraph();
        setButtonListener();
    }

    private void bindViews(){
        mPbLoading = (ProgressBar) findViewById(R.id.pbLoading);
        mButtonGetActors = (Button) findViewById(R.id.btnShowRepositories);
        mTvActorList = (TextView) findViewById(R.id.tvActorList);
    }

    private void initDaggerLoginActivityGraph(){
        //1. Initialize actorsListActivityComponent as we did in Exercise 1 (Exercise1Application.class)
        //2. Use inject method in actorsListActivityComponent to make injection available for this class
    }

    private void setButtonListener(){
        mButtonGetActors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getActors();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (mPresenter != null){
            Log.i(DAGGER_LOG, "Presenter not null!");
        }
    }

    public void showLoading(){
        mPbLoading.setVisibility(View.VISIBLE);
    }

    public void hideLoading(){
        mPbLoading.setVisibility(View.GONE);
    }

    public void showActors(String actors) {
        mTvActorList.setText(actors);
    }
}
