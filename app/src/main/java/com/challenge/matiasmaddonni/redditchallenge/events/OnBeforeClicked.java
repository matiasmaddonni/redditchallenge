package com.challenge.matiasmaddonni.redditchallenge.events;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class OnBeforeClicked {
    private String id;

    public OnBeforeClicked(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
