package com.challenge.matiasmaddonni.redditchallenge.activities;

import android.os.Bundle;

import com.challenge.matiasmaddonni.redditchallenge.R;
import com.challenge.matiasmaddonni.redditchallenge.base.BaseActivity;
import com.challenge.matiasmaddonni.redditchallenge.base.BasePresenter;
import com.challenge.matiasmaddonni.redditchallenge.mvp.model.activities.DescriptionModel;
import com.challenge.matiasmaddonni.redditchallenge.mvp.presenter.activities.DescriptionPresenter;
import com.challenge.matiasmaddonni.redditchallenge.mvp.view.activities.DescriptionView;
import com.challenge.matiasmaddonni.redditchallenge.utils.BusProvider;


public class DescriptionActivity extends BaseActivity {

    private DescriptionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        presenter = new DescriptionPresenter(new DescriptionModel(BusProvider.getInstance()),
                new DescriptionView(this, BusProvider.getInstance()));

        BusProvider.register(presenter);

        if (savedInstanceState == null) {
            presenter.afterBusIsRegistered(getIntent().getExtras());
        } else {
            presenter.afterBusIsRegistered(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        presenter.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
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