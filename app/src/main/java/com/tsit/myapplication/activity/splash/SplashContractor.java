package com.tsit.myapplication.activity.splash;

interface SplashContractor {
    interface iView {
        void goToMainPage();
    }

    interface iModel {
        long getTimer();
    }

    interface iPresenter {
        void onCreateView();
    }
}
