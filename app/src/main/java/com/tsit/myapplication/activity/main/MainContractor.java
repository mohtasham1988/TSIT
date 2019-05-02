package com.tsit.myapplication.activity.main;

interface MainContractor {

    interface iView {

        void showPage(int i);
    }

    interface iModel {

     }

    interface iPresenter {

        void onCreateView();
    }
}
