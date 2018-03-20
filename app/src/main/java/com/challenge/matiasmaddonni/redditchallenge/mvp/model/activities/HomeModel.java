package com.challenge.matiasmaddonni.redditchallenge.mvp.model.activities;

import com.challenge.matiasmaddonni.redditchallenge.base.BaseModel;
import com.challenge.matiasmaddonni.redditchallenge.events.GetAfterFailed;
import com.challenge.matiasmaddonni.redditchallenge.events.GetAfterSuccess;
import com.challenge.matiasmaddonni.redditchallenge.events.GetBeforeFailed;
import com.challenge.matiasmaddonni.redditchallenge.events.GetBeforeSuccess;
import com.challenge.matiasmaddonni.redditchallenge.events.GetTopFailed;
import com.challenge.matiasmaddonni.redditchallenge.events.GetTopSuccess;
import com.challenge.matiasmaddonni.redditchallenge.network.ServiceManager;
import com.squareup.otto.Bus;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class HomeModel extends BaseModel {

    private Bus bus;

    public HomeModel(Bus bus) {
        this.bus = bus;
    }

    public void getTop() {
        ServiceManager.getInstance().getBackendApiService().getTopSubReddit(50, 50)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                    if (response != null
                            && response.getData() != null
                            && response.getData().getChildren() != null) {
                        bus.post(new GetTopSuccess(response));
                    } else {
                        bus.post(new GetTopFailed("Failed to get posts"));
                    }
                }, throwable -> {
                    bus.post(new GetTopFailed(throwable.getMessage()));
                });
    }

    public void getBefore(String before) {
        ServiceManager.getInstance().getBackendApiService().getPageBefore(50, 50, before)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                    if (response != null
                            && response.getData() != null
                            && response.getData().getChildren() != null) {
                        bus.post(new GetBeforeSuccess(response));
                    } else {
                        bus.post(new GetBeforeFailed("Failed to get previous posts"));
                    }
                }, throwable -> {
                    bus.post(new GetBeforeFailed(throwable.getMessage()));
                });
    }

    public void getAfter(String after) {
        ServiceManager.getInstance().getBackendApiService().getPageAfter(50, 50, after)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                    if (response != null
                            && response.getData() != null
                            && response.getData().getChildren() != null) {
                        bus.post(new GetAfterSuccess(response));
                    } else {
                        bus.post(new GetAfterFailed("Failed to get next posts"));
                    }
                }, throwable -> {
                    bus.post(new GetAfterFailed(throwable.getMessage()));
                });
    }
}
