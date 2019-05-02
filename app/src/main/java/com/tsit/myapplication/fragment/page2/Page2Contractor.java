package com.tsit.myapplication.fragment.page2;

import java.util.List;

import io.reactivex.Observable;

interface Page2Contractor {

    interface iView {

        void initList(List<String> list);
    }

    interface iModel {

        Observable<String> getList();
    }

    interface iPresenter {
        void onCreateView();

     }
}
