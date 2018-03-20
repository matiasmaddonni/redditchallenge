package com.challenge.matiasmaddonni.redditchallenge.events;

import com.challenge.matiasmaddonni.redditchallenge.network.model.RedditResponse;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class GetAfterSuccess {
    private RedditResponse response;

    public GetAfterSuccess(RedditResponse response) {
        this.response = response;
    }

    public RedditResponse getResponse() {
        return response;
    }
}
