package com.challenge.matiasmaddonni.redditchallenge.utils;

import com.squareup.otto.Bus;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class BusProvider {
    private static final Bus BUS_INSTANCE = new MainPostingBus();

    private BusProvider() {
    }

    public static Bus getInstance() {
        return BUS_INSTANCE;
    }

    public static void register(Object... objects) {
        for (Object o : objects) {
            if (o != null) {
                BUS_INSTANCE.register(o);
            }
        }
    }

    public static void unregister(Object... objects) {
        for (Object o : objects) {
            if (o != null) {
                BUS_INSTANCE.unregister(o);
            }
        }
    }
}
