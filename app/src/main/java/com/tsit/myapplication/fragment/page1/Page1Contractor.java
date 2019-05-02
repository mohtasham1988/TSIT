package com.tsit.myapplication.fragment.page1;

import android.os.Bundle;

interface Page1Contractor {

    interface iView {

        void initWebView(Bundle savedInstanceState);
        void startPage2();
        void initImageView(String[] array);
    }

    interface iModel {

        String[] getArray();
    }

    interface iPresenter {
        void onCreateView(Bundle savedInstanceState);

        void startPage2();
    }
}
