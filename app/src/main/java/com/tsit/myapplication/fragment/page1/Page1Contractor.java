package com.tsit.myapplication.fragment.page1;

interface Page1Contractor {

    interface iView {

        void initWebView();
        void startPage2();
        void initImageView(String[] array);
    }

    interface iModel {

        String[] getArray();
    }

    interface iPresenter {
        void onCreateView();

        void startPage2();
    }
}
