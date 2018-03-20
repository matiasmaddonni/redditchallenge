package com.challenge.matiasmaddonni.redditchallenge.events;

import com.challenge.matiasmaddonni.redditchallenge.network.model.RedditResponse;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class GetBeforeSuccess {
    private RedditResponse response;

    public GetBeforeSuccess(RedditResponse response) {
        this.response = response;
    }

    public RedditResponse getResponse() {
        return response;
    }
}
