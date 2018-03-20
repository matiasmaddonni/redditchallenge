package com.challenge.matiasmaddonni.redditchallenge.mvp.model.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.challenge.matiasmaddonni.redditchallenge.base.BaseModel;
import com.challenge.matiasmaddonni.redditchallenge.events.SavedImageFailed;
import com.challenge.matiasmaddonni.redditchallenge.events.SavedImageSuccess;
import com.squareup.otto.Bus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


public class DescriptionModel extends BaseModel {

    private Bus bus;

    public DescriptionModel(Bus bus) {
        this.bus = bus;
    }

    public void saveThumbnail(String url) {
        URL imageurl;
        try {
            imageurl = new URL(url);
            Bitmap bitmap = BitmapFactory.decodeStream(imageurl.openConnection().getInputStream());

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bytes);

            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root + "/saved_images");
            myDir.mkdirs();

            String fname = "thumbnail.jpg";
            File file = new File (myDir, fname);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            FileOutputStream fo = new FileOutputStream(file);
            fo.write(bytes.toByteArray());
            fo.close();

            bus.post(new SavedImageSuccess());
        } catch (IOException e) {
            e.printStackTrace();
            bus.post(new SavedImageFailed("Failed to store image on sdcard"));
        }
    }
}
