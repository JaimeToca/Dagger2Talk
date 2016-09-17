package com.example.testing.exercise3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.testing.exercise3.ui.component.ActorsListActivityComponent;
import com.example.testing.exercise3.ui.module.ActorsListActivityModule;
import com.example.testing.exercise3.ui.presenter.GetActorsPresenter;

import javax.inject.Inject;

public class ActorsListActivity extends AppCompatActivity {

    private static String DAGGER_LOG = "Dagger";

    private ActorsListActivityComponent actorsListActivityComponent;
    private ProgressBar mPbLoading;
    private Button mButtonGetActors;
    private TextView mTvActorList;
    @Inject GetActorsPresenter mPresenter;
    @Inject SharedPreferences mSharePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        initLoginActivitySubGraph();
        setButtonListener();
    }

    private void bindViews(){
        mPbLoading = (ProgressBar) findViewById(R.id.pbLoading);
        mButtonGetActors = (Button) findViewById(R.id.btnShowRepositories);
        mTvActorList = (TextView) findViewById(R.id.tvActorList);
    }

    private void initLoginActivitySubGraph(){
        //1. Initialize activity subgraph. You should use getApplicationComponent from Exercise3Application.class
        //and use "plus" method to set ActorsListActivityModule in the subgraph

        //2. Use inject method in actorsListActivityComponent to make injection available for this class
        actorsListActivityComponent = ((Exercise3Application)getApplication())
                .getApplicationComponent()
                .plus(new ActorsListActivityModule(this));
        actorsListActivityComponent.inject(this);
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
        if ((mPresenter != null) && (mSharePreferences != null)){
            Log.i(DAGGER_LOG, "Presenter and sharePreferences not null!");
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

    @Override
    public void finish() {
        super.finish();
        //3. Release ActorsListActivityComponent
        actorsListActivityComponent = null;
    }
}
