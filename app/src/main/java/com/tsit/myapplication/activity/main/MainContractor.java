package com.tsit.myapplication.activity.main;

import android.os.Bundle;

interface MainContractor {

    interface iView {

        void showPage(int i, Bundle savedInstanceState);
    }

    interface iModel {

     }

    interface iPresenter {

        void onCreateView(Bundle savedInstanceState);
    }
}
