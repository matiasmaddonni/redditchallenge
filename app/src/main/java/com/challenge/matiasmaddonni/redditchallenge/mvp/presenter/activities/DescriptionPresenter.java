package com.challenge.matiasmaddonni.redditchallenge.mvp.presenter.activities;

import android.os.Bundle;

import com.challenge.matiasmaddonni.redditchallenge.base.BasePresenter;
import com.challenge.matiasmaddonni.redditchallenge.events.OnThumbnailClick;
import com.challenge.matiasmaddonni.redditchallenge.events.SavedImageFailed;
import com.challenge.matiasmaddonni.redditchallenge.events.SavedImageSuccess;
import com.challenge.matiasmaddonni.redditchallenge.mvp.model.activities.DescriptionModel;
import com.challenge.matiasmaddonni.redditchallenge.mvp.view.activities.DescriptionView;
import com.squareup.otto.Subscribe;


public class DescriptionPresenter extends BasePresenter {

    private DescriptionModel model;
    private DescriptionView view;

    public DescriptionPresenter(DescriptionModel model, DescriptionView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }

    public void afterBusIsRegistered(Bundle bundle) {
        view.refreshUI(bundle);
    }

    public void saveInstanceState(Bundle outState) {
        view.saveInstanceState(outState);
    }

    @Subscribe
    public void onThumbnailClicked(OnThumbnailClick event) {
        view.showLoadingOverlay();
        model.saveThumbnail(event.getThumbnail());
    }

    @Subscribe
    public void onSavedImageSuccess(SavedImageSuccess event) {
        view.hideLoadingOverlay();
        view.showMessage("Success");
    }

    @Subscribe
    public void onSavedImageFailed(SavedImageFailed event) {
        view.hideLoadingOverlay();
        view.showMessage(event.getMessage());
    }
}
