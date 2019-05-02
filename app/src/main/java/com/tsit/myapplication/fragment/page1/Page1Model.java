package com.tsit.myapplication.fragment.page1;


class Page1Model implements Page1Contractor.iModel {
    private Page1Contractor.iPresenter iPresenter;
    private String[] array = {"https://homepages.cae.wisc.edu/~ece533/images/airplane.png", "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png", "https://picsum.photos/id/237/400/400", "https://picsum.photos/id/423/400/400?grayscale"};

    Page1Model(Page1Contractor.iPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    @Override
    public String[] getArray() {
        return array;
    }
}
