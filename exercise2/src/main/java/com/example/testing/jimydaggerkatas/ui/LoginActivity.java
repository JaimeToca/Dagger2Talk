package com.example.testing.jimydaggerkatas.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.testing.jimydaggerkatas.R;
import com.example.testing.jimydaggerkatas.ui.component.DaggerLoginActivityComponent;
import com.example.testing.jimydaggerkatas.ui.component.LoginActivityComponent;
import com.example.testing.jimydaggerkatas.ui.module.LoginActivityModule;
import com.example.testing.jimydaggerkatas.ui.presenter.GetActorsPresenter;
import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

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
        LoginActivityComponent loginActivityComponent = DaggerLoginActivityComponent
                .builder()
                .loginActivityModule(new LoginActivityModule(this))
                .build();
        loginActivityComponent.inject(this);
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
