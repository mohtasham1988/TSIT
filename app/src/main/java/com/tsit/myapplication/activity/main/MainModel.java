package com.tsit.myapplication.activity.main;

class MainModel implements MainContractor.iModel {
    private MainContractor.iPresenter iPresenter;

    MainModel(MainContractor.iPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

}
