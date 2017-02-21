package com.tihi.multiprocess;

import android.app.Application;

import com.tihi.multiprocess.Util.Util;

/**
 * description:
 * author: duantianhui
 * date: 2017/2/21 9:44
 */

public class App extends Application{
    private static App _instance;
    private static final String TAG_PREFIX = "App";

    @Override
    public void onCreate() {
        super.onCreate();

        _instance = this;
        Util.printCurProThr(TAG_PREFIX + "_" + hashCode());
    }

    public static App instance() {
        return _instance;
    }
}
