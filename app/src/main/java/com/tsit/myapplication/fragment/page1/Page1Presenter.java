package com.tsit.myapplication.fragment.page1;


class Page1Presenter implements Page1Contractor.iPresenter {
    private Page1Contractor.iModel mModel;
    private Page1Contractor.iView mView;

    Page1Presenter(Page1Contractor.iView iView) {
        this.mView = iView;
        this.mModel = new Page1Model(this);
    }

    @Override
    public void onCreateView() {
        mView.initWebView();
        mView.initImageView(mModel.getArray());
    }

    @Override
    public void startPage2() {
        mView.startPage2();
    }
}
