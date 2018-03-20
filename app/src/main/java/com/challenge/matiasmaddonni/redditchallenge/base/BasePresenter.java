package com.challenge.matiasmaddonni.redditchallenge.base;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public abstract class BasePresenter {

    public Object busEventListener;

    BaseModel baseModel;
    BaseView baseView;

    public BasePresenter(BaseModel model, BaseView view) {
        this.baseModel = model;
        this.baseView = view;
    }

    public void showWaitOverlay() {
        baseView.showLoadingOverlay();
    }

    public void closeWaitOverlay() {
        baseView.hideLoadingOverlay();
    }
}
