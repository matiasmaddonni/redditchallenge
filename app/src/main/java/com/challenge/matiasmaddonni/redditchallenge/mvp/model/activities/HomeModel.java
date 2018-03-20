package com.challenge.matiasmaddonni.redditchallenge.mvp.model.activities;

import com.challenge.matiasmaddonni.redditchallenge.base.BaseModel;
import com.squareup.otto.Bus;


public class HomeModel extends BaseModel {

    private Bus bus;

    public HomeModel(Bus bus) {
        this.bus = bus;
    }
}
