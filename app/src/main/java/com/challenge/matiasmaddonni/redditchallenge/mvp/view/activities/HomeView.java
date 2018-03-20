package com.challenge.matiasmaddonni.redditchallenge.mvp.view.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.challenge.matiasmaddonni.redditchallenge.R;
import com.challenge.matiasmaddonni.redditchallenge.adapters.PostAdapter;
import com.challenge.matiasmaddonni.redditchallenge.base.BaseActivity;
import com.challenge.matiasmaddonni.redditchallenge.base.BaseView;
import com.challenge.matiasmaddonni.redditchallenge.events.OnAfterClicked;
import com.challenge.matiasmaddonni.redditchallenge.events.OnBeforeClicked;
import com.challenge.matiasmaddonni.redditchallenge.events.OnPostsSwiped;
import com.challenge.matiasmaddonni.redditchallenge.network.model.RedditResponse;
import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeView extends BaseView {

    @BindView(R.id.main_swipe_refresh)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.main_recycler)
    RecyclerView mainRecycler;

    private PostAdapter adapter;
    private RedditResponse response;

    public HomeView(BaseActivity activity, Bus bus) {
        super(activity, bus);

        refreshLayout.setOnRefreshListener(() -> refreshItems());
    }

    private void refreshItems() {
        bus.post(new OnPostsSwiped());
    }

    public void updatePosts(RedditResponse response) {
        this.response = response;

        if (adapter == null) {
            mainRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new PostAdapter(getActivity(), response.getData().getChildren());
            mainRecycler.setAdapter(adapter);
        } else {
            adapter.setPosts(response.getData().getChildren());
        }

        refreshLayout.setRefreshing(false);
    }

    @OnClick(R.id.before_btn)
    public void onBeforeClick() {
        bus.post(new OnBeforeClicked(response.getData().getBefore()));
    }

    @OnClick(R.id.after_btn)
    public void onAfterClick() {
        bus.post(new OnAfterClicked(response.getData().getAfter()));
    }

    @OnClick(R.id.dismiss_btn)
    public void onDismissClick() {
        adapter.dismissPosts();
    }

    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}