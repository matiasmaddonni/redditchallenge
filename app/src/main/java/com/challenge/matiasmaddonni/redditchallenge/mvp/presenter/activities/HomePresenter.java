package com.challenge.matiasmaddonni.redditchallenge.mvp.presenter.activities;

import com.challenge.matiasmaddonni.redditchallenge.base.BasePresenter;
import com.challenge.matiasmaddonni.redditchallenge.events.GetAfterFailed;
import com.challenge.matiasmaddonni.redditchallenge.events.GetAfterSuccess;
import com.challenge.matiasmaddonni.redditchallenge.events.GetBeforeFailed;
import com.challenge.matiasmaddonni.redditchallenge.events.GetBeforeSuccess;
import com.challenge.matiasmaddonni.redditchallenge.events.GetTopFailed;
import com.challenge.matiasmaddonni.redditchallenge.events.GetTopSuccess;
import com.challenge.matiasmaddonni.redditchallenge.events.OnAfterClicked;
import com.challenge.matiasmaddonni.redditchallenge.events.OnBeforeClicked;
import com.challenge.matiasmaddonni.redditchallenge.events.OnPostsSwiped;
import com.challenge.matiasmaddonni.redditchallenge.mvp.model.activities.HomeModel;
import com.challenge.matiasmaddonni.redditchallenge.mvp.view.activities.HomeView;
import com.squareup.otto.Subscribe;


public class HomePresenter extends BasePresenter {

    private HomeModel model;
    private HomeView view;

    public HomePresenter(HomeModel model, HomeView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }

    public void afterBusIsRegistered() {
        view.showLoadingOverlay();
        model.getTop();
    }

    @Subscribe
    public void onPostsSwiped(OnPostsSwiped event) {
        model.getTop();
    }

    @Subscribe
    public void onBeforeClicked(OnBeforeClicked event) {
        view.showLoadingOverlay();
        model.getBefore(event.getId());
    }

    @Subscribe
    public void onAfterClicked(OnAfterClicked event) {
        view.showLoadingOverlay();
        model.getAfter(event.getId());
    }

    @Subscribe
    public void onTopSuccess(GetTopSuccess event) {
        view.hideLoadingOverlay();
        view.updatePosts(event.getResponse());
    }

    @Subscribe
    public void onTopFailed(GetTopFailed event) {
        view.hideLoadingOverlay();
        view.showError(event.getMessage());
    }

    @Subscribe
    public void onAfterSuccess(GetAfterSuccess event) {
        view.hideLoadingOverlay();
        view.updatePosts(event.getResponse());
    }

    @Subscribe
    public void onAfterFailed(GetAfterFailed event) {
        view.hideLoadingOverlay();
        view.showError(event.getMessage());
    }

    @Subscribe
    public void onBeforeSuccess(GetBeforeSuccess event) {
        view.hideLoadingOverlay();
        view.updatePosts(event.getResponse());
    }

    @Subscribe
    public void onBeforeFailed(GetBeforeFailed event) {
        view.hideLoadingOverlay();
        view.showError(event.getMessage());
    }
}
