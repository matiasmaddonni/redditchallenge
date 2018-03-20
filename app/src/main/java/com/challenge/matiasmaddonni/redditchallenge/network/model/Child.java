package com.challenge.matiasmaddonni.redditchallenge.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class Child implements Serializable {

    @SerializedName("data")
    @Expose
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
