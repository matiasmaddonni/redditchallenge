package com.challenge.matiasmaddonni.redditchallenge.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.challenge.matiasmaddonni.redditchallenge.R;
import com.squareup.otto.Bus;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class BaseView {

    private WeakReference<BaseActivity> activityRef;
    protected Bus bus;

    @BindView(R.id.progress_layout)
    View loadingOverlay;

    public BaseView(BaseActivity activity, Bus bus) {
        activityRef = new WeakReference<>(activity);
        this.bus = bus;

        ButterKnife.bind(this, activity);
    }

    @Nullable
    public AppCompatActivity getActivity() {
        return activityRef.get();
    }

    @Nullable
    public Context getContext() {
        return getActivity();
    }

    public void showLoadingOverlay() {
        loadingOverlay.setVisibility(View.VISIBLE);
    }

    public void hideLoadingOverlay() {
        loadingOverlay.setVisibility(View.GONE);
    }
}
