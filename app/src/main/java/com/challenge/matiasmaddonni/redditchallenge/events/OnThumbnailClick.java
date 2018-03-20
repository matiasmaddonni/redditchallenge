package com.challenge.matiasmaddonni.redditchallenge.events;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class OnThumbnailClick {
    private String thumbnail;

    public OnThumbnailClick(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
