package com.challenge.matiasmaddonni.redditchallenge.activities;

import android.os.Bundle;

import com.challenge.matiasmaddonni.redditchallenge.R;
import com.challenge.matiasmaddonni.redditchallenge.base.BaseActivity;
import com.challenge.matiasmaddonni.redditchallenge.base.BasePresenter;
import com.challenge.matiasmaddonni.redditchallenge.mvp.model.activities.HomeModel;
import com.challenge.matiasmaddonni.redditchallenge.mvp.presenter.activities.HomePresenter;
import com.challenge.matiasmaddonni.redditchallenge.mvp.view.activities.HomeView;
import com.challenge.matiasmaddonni.redditchallenge.utils.BusProvider;


public class HomeActivity extends BaseActivity {

    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter = new HomePresenter(new HomeModel(BusProvider.getInstance()),
                new HomeView(this, BusProvider.getInstance()));

        BusProvider.register(presenter);
        presenter.afterBusIsRegistered();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.unregister(presenter);
    }

    @Override
    protected BasePresenter getBasePresenter() {
        return this.presenter;
    }


}