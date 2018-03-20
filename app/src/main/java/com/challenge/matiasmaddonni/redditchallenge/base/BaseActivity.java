package com.challenge.matiasmaddonni.redditchallenge.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.challenge.matiasmaddonni.redditchallenge.R;
import com.challenge.matiasmaddonni.redditchallenge.utils.BusProvider;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ViewGroup baseActivityLayout;
    private ViewGroup mainContainer;

    BasePresenter basePresenter;

    public void setBasePresenter(BasePresenter basePresenter) {
        this.basePresenter = basePresenter;
    }

    protected abstract BasePresenter getBasePresenter();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

        baseActivityLayout = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_base, null);
        mainContainer = (ViewGroup) baseActivityLayout.findViewById(R.id.main_container);
        getLayoutInflater().inflate(layoutResID, mainContainer, true);

        setContentView(baseActivityLayout);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setBasePresenter(getBasePresenter());
        BusProvider.register(basePresenter);
    }

    @Override
    protected void onDestroy() {
        BusProvider.unregister(basePresenter);
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
