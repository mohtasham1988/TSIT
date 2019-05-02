package com.tsit.myapplication.activity.splash;

import java.util.Timer;
import java.util.TimerTask;

class SplashPresenter implements SplashContractor.iPresenter {
    private SplashContractor.iModel mModel;
    private SplashContractor.iView mView;

    SplashPresenter(SplashContractor.iView iView) {
        this.mView=iView;
        this.mModel = new SplashModel(this);
    }

    @Override
    public void onCreateView() {

         new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mView.goToMainPage();
            }
        },mModel.getTimer());
    }
}
