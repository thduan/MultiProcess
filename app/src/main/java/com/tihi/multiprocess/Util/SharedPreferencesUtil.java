package com.tihi.multiprocess.Util;

import android.content.SharedPreferences;
import android.util.Log;

import com.tihi.multiprocess.App;

/**
 * description:
 * author: duantianhui
 * date: 2017/2/21 10:29
 */

public class SharedPreferencesUtil {
    private static final String PREFERENCE_FILE = "multiprocess_share_file";

    private static SharedPreferencesUtil _instance;

    public SharedPreferencesUtil() {
    }

    public static SharedPreferencesUtil instance() {
        if(_instance == null) {
            synchronized (SharedPreferencesUtil.class){
                if(_instance == null) {
                    _instance = new SharedPreferencesUtil();
                }
            }
        }
        return _instance;
    }

    public static void save(String key, String value) {
        Util.printCurProThr();
        SharedPreferences sharedPreferences = App.instance().getSharedPreferences(PREFERENCE_FILE, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String get(String key) {
        Util.printCurProThr();
        SharedPreferences sharedPreferences = App.instance().getSharedPreferences(PREFERENCE_FILE, 0);
        return sharedPreferences.getString(key, "");
    }


    public interface Keys{
        String DEMO_TEST_KEY = "demo_test_key";
    }

}
