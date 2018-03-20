package com.challenge.matiasmaddonni.redditchallenge.events;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class OnAfterClicked {
    private String id;

    public OnAfterClicked(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
