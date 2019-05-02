package com.tsit.myapplication.fragment.page2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

interface Page2Contractor {

    interface iView {

        void initList(List<String> integers);
        ArrayList<String> getList();
    }

    interface iModel {

        Observable<String> getList();
    }

    interface iPresenter {
        void onCreateView(Bundle savedInstanceState);

        void onSaveInstanceState(Bundle outState);
    }
}
