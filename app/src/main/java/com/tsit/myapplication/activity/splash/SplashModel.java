package com.tsit.myapplication.activity.splash;

class SplashModel implements SplashContractor.iModel {
    private SplashContractor.iPresenter iPresenter;
    private long mTimer = 3000;

    SplashModel(SplashContractor.iPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    @Override
    public long getTimer() {
        return mTimer;
    }
}
