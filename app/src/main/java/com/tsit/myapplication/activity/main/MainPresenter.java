package com.tsit.myapplication.activity.main;

class MainPresenter implements MainContractor.iPresenter {
    private MainContractor.iModel mModel;
    private MainContractor.iView mView;

    MainPresenter(MainContractor.iView iView) {
        this.mView = iView;
        this.mModel = new MainModel(this);
    }

    @Override
    public void onCreateView() {
        mView.showPage(1);
    }


}
