package com.challenge.matiasmaddonni.redditchallenge.mvp.presenter.activities;

import com.challenge.matiasmaddonni.redditchallenge.base.BasePresenter;
import com.challenge.matiasmaddonni.redditchallenge.mvp.model.activities.HomeModel;
import com.challenge.matiasmaddonni.redditchallenge.mvp.view.activities.HomeView;


public class HomePresenter extends BasePresenter {

    private HomeModel model;
    private HomeView view;

    public HomePresenter(HomeModel model, HomeView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }
}
