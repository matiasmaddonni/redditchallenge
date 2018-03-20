package com.challenge.matiasmaddonni.redditchallenge.mvp.view.activities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.challenge.matiasmaddonni.redditchallenge.R;
import com.challenge.matiasmaddonni.redditchallenge.base.BaseActivity;
import com.challenge.matiasmaddonni.redditchallenge.base.BaseView;
import com.challenge.matiasmaddonni.redditchallenge.common.Constants;
import com.challenge.matiasmaddonni.redditchallenge.events.OnThumbnailClick;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.OnClick;

public class DescriptionView extends BaseView {

    @BindView(R.id.description_toolbar)
    Toolbar toolbar;
    @BindView(R.id.description_author)
    TextView authorTextView;
    @BindView(R.id.description_thumbnail)
    ImageView thumbnailImageView;
    @BindView(R.id.description_title)
    TextView titleTextView;

    private String author, thumbnail, title;

    public DescriptionView(BaseActivity activity, Bus bus) {
        super(activity, bus);

        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void saveInstanceState(Bundle outState) {
        outState.putString(Constants.POST_AUTHOR, author);
        outState.putString(Constants.POST_THUMBNAIL, thumbnail);
        outState.putString(Constants.POST_TITLE, title);
    }

    public void refreshUI(Bundle bundle) {
        author = bundle.getString(Constants.POST_AUTHOR);
        thumbnail = bundle.getString(Constants.POST_THUMBNAIL);
        title = bundle.getString(Constants.POST_TITLE);

        updateUI();
    }

    private void updateUI() {
        authorTextView.setText(author);
        Picasso.with(getActivity())
                .load(thumbnail)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(thumbnailImageView);
        titleTextView.setText(title);
    }

    @OnClick(R.id.description_thumbnail)
    public void onThumbnailClick() {
        verifyStoragePermissions(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do you want to download this image?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", (dialog, which) -> bus.post(new OnThumbnailClick(thumbnail)));
        builder.setNegativeButton("No", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    /**
     * Checks if the app has permission to write to device storage
     *
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}