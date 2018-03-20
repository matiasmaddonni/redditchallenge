package com.challenge.matiasmaddonni.redditchallenge.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.challenge.matiasmaddonni.redditchallenge.R;
import com.challenge.matiasmaddonni.redditchallenge.adapters.viewholders.PostViewHolder;
import com.challenge.matiasmaddonni.redditchallenge.events.OnPostClicked;
import com.challenge.matiasmaddonni.redditchallenge.network.model.Body;
import com.challenge.matiasmaddonni.redditchallenge.network.model.Child;
import com.challenge.matiasmaddonni.redditchallenge.utils.DateUtils;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by matias.maddonni on 3/20/2018.
 *
 * Adapter used on Home Activity for showing the response from Reddit
 */

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private Bus bus;
    private List<Child> posts;

    public PostAdapter(Context context, Bus bus, List<Child> posts) {
        this.context = context;
        this.bus = bus;
        this.posts = posts;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PostViewHolder pvh = (PostViewHolder) holder;
        pvh.title.setText(posts.get(position).getBody().getTitle());
        pvh.author.setText(posts.get(position).getBody().getAuthor());
        pvh.comments.setText(context.getResources().getString(R.string.comments, posts.get(position).getBody().getNumComments()));
        Long minutes = getMinutes(posts.get(position).getBody().getCreatedUtc());
        if (minutes / 60 >= 1) {
            pvh.entryDate.setText(context.getResources().getString(R.string.hours_ago, (minutes / 60)));
        } else {
            pvh.entryDate.setText(context.getResources().getString(R.string.minutes_ago, minutes));
        }
        Picasso.with(context)
                .load(posts.get(position).getBody().getThumbnail())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(pvh.thumbnail);
        pvh.bullet.setVisibility(posts.get(position).getBody().isRead() ? View.GONE : View.VISIBLE);
        pvh.dismissBtn.setOnClickListener(v -> {
            posts.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, posts.size());
        });
        pvh.container.setOnClickListener(v -> {
            Body body = posts.get(position).getBody();
            body.setRead(true);
            notifyDataSetChanged();

            bus.post(new OnPostClicked(body.getAuthor(), body.getThumbnail(), body.getTitle()));
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Child> newPosts) {
        this.posts = newPosts;
        notifyDataSetChanged();
    }

    public void dismissPosts() {
        final int size = posts.size();
        posts.clear();
        notifyItemRangeRemoved(0, size);
    }

    private long getMinutes(Double time) {
        Date now = new Date();
        Date date = new Date(time.longValue() * 1000);
        return DateUtils.getDateDiff(date, now, TimeUnit.MINUTES);
    }
}
