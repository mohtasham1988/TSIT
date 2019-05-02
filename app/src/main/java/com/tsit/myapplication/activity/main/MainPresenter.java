package com.tsit.myapplication.activity.main;

import android.os.Bundle;

class MainPresenter implements MainContractor.iPresenter {
    private MainContractor.iModel mModel;
    private MainContractor.iView mView;

    MainPresenter(MainContractor.iView iView) {
        this.mView = iView;
        this.mModel = new MainModel(this);
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        mView.showPage(1,savedInstanceState);
    }


}
