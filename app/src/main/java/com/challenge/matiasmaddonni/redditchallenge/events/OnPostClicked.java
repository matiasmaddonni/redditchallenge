package com.challenge.matiasmaddonni.redditchallenge.events;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class OnPostClicked {
    private String author;
    private String thumbnail;
    private String title;

    public OnPostClicked(String author, String thumbnail, String title) {
        this.author = author;
        this.thumbnail = thumbnail;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }
}
