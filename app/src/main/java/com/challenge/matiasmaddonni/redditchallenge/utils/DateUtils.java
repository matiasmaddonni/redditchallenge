package com.challenge.matiasmaddonni.redditchallenge.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by matias.maddonni on 3/20/2018.
 */

public class DateUtils {
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
