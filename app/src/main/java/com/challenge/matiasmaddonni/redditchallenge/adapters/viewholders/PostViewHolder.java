package com.challenge.matiasmaddonni.redditchallenge.adapters.viewholders;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.challenge.matiasmaddonni.redditchallenge.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.post_author)
    public TextView author;
    @BindView(R.id.post_entry_date)
    public TextView entryDate;
    @BindView(R.id.post_title)
    public TextView title;
    @BindView(R.id.post_comments)
    public TextView comments;
    @BindView(R.id.post_container)
    public ConstraintLayout container;
    @BindView(R.id.post_thumbnail)
    public ImageView thumbnail;
    @BindView(R.id.post_bullet)
    public TextView bullet;
    @BindView(R.id.dismiss_post)
    public Button dismissBtn;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
