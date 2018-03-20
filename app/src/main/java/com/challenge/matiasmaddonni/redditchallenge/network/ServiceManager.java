package com.challenge.matiasmaddonni.redditchallenge.network;

/**
 * Created by matias.maddonni on 3/20/2018.
 *
 * Singleton for managing the retrofit interface
 */

public class ServiceManager {
    private static ServiceManager mInstance = null;

    private BackendApiService mBackendApiService;

    private ServiceManager() {
        mBackendApiService = BackendApiService.Factory.create();
    }

    public static ServiceManager getInstance() {
        if (mInstance == null) {
            mInstance = new ServiceManager();
        }

        return mInstance;
    }

    public BackendApiService getBackendApiService() {
        return mBackendApiService;
    }
}
