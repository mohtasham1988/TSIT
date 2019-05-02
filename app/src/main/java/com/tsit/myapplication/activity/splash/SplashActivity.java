package com.tsit.myapplication.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tsit.myapplication.activity.main.MainActivity;
import com.tsit.myapplication.R;

public class SplashActivity extends AppCompatActivity implements SplashContractor.iView {
    SplashContractor.iPresenter iPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter=new SplashPresenter(this);
        setContentView(R.layout.activity_splash);
        iPresenter.onCreateView();
    }

    @Override
    public void goToMainPage() {
       startActivity(new Intent(this, MainActivity.class));
       finish();
    }
}
