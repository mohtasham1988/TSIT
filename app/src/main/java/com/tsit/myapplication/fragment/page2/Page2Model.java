package com.tsit.myapplication.fragment.page2;


import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class Page2Model implements Page2Contractor.iModel {
    private Page2Contractor.iPresenter iPresenter;

    Page2Model(Page2Contractor.iPresenter iPresenter) {
        this.iPresenter = iPresenter;

    }

    @Override
    public Observable<String> getList() {

        return Observable.range(0,100)
               .flatMap(integer -> {
                   Random random=new Random();
                   long number = random.nextLong();
                   return Observable.just((number>0)?number+"":(number*-1)+"");

               })  ;

    }


}
