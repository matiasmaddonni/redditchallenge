package com.challenge.matiasmaddonni.redditchallenge.events;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class GetTopFailed {
    private String message;

    public GetTopFailed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
