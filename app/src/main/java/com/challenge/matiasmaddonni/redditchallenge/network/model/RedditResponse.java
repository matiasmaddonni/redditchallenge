package com.challenge.matiasmaddonni.redditchallenge.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by matias.maddonni on 3/20/2018.
 *
 * Matches the response from http://api.reddit.com/top
 */

public class RedditResponse implements Serializable {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
