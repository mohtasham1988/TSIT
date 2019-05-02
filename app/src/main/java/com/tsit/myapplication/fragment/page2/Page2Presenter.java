package com.tsit.myapplication.fragment.page2;


import android.os.Bundle;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class Page2Presenter implements Page2Contractor.iPresenter {
    public static final String LIST = "list";
    private Page2Contractor.iModel mModel;
    private Page2Contractor.iView mView;

    Page2Presenter(Page2Contractor.iView iView) {
        this.mView = iView;
        this.mModel = new Page2Model(this);
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey(LIST)) {
            Log.d("vahid", "onCreateView: " + (savedInstanceState == null && savedInstanceState.containsKey("list")));
            mView.initList(savedInstanceState.getStringArrayList(LIST));
        } else
            mModel.getList()
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(s -> {
                        return split(s.charAt(0), s.substring(0, s.length()));
                    })
                    .toList()
                    .subscribe((integers, throwable) -> {
                        mView.initList(integers);
                    });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList(LIST, mView.getList());
    }

    public String split(char char1, String sub) {
        if (char1 == sub.charAt(0))
            return char1 + "" + (sub.length() > 1 ? split(sub.charAt(0), sub.substring(1)) : sub.charAt(0));
        else
            return char1 + "," + (sub.length() > 1 ? split(sub.charAt(0), sub.substring(1)) : sub.charAt(0));
    }
}
