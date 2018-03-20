package com.challenge.matiasmaddonni.redditchallenge.network;

import com.challenge.matiasmaddonni.redditchallenge.common.Constants;
import com.challenge.matiasmaddonni.redditchallenge.network.model.RedditResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public interface BackendApiService {
    @GET(Constants.TOP)
    Observable<RedditResponse> getTopSubReddit(@Query("limit") int limit, @Query("count") int count);

    @GET(Constants.TOP)
    Observable<RedditResponse> getPageAfter(@Query("limit") int limit, @Query("count") int count, @Query("after") String after);

    @GET(Constants.TOP)
    Observable<RedditResponse> getPageBefore(@Query("limit") int limit, @Query("count") int count, @Query("before") String before);

    /********
     * Helper class that sets up a new services
     *******/
    class Factory {
        public static BackendApiService create() {
            Gson gson = new GsonBuilder().create();
            Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
            return retrofit.create(BackendApiService.class);
        }
    }
}
