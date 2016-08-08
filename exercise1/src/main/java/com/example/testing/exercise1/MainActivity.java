package com.example.testing.exercise1;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject SharedPreferences mPreferences;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        initDependacyGraph();
    }

    private void initDependacyGraph(){
        ((Exercise1Application)getApplication()).getApplicationComponent().inject(this);
    }

    private void bindViews(){
        tvResult = (TextView) findViewById(R.id.tvResult);
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
