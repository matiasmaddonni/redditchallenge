package com.challenge.matiasmaddonni.redditchallenge.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class Data implements Serializable {

    @SerializedName("after")
    @Expose
    private String after;
    @SerializedName("children")
    @Expose
    private List<Child> children = null;
    @SerializedName("before")
    @Expose
    private String before;

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }
}
