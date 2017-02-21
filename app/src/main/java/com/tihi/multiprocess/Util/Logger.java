package com.tihi.multiprocess.Util;

import android.util.Log;

import com.tihi.multiprocess.BuildConfig;

/**
 * description:
 * author: duantianhui
 * date: 2017/2/21 9:59
 */

public class Logger {
    private static boolean isDebug = BuildConfig.DEBUG;
    private static String TAG = "multiProcessDemo";


    public static void log(String msg) {
        if(isDebug) {
            Log.i(TAG, msg);
        }
    }

}
