package com.challenge.matiasmaddonni.redditchallenge.events;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class SavedImageFailed {
    private String message;

    public SavedImageFailed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
