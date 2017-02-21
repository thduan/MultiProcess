package com.tihi.multiprocess.Util;

import android.app.ActivityManager;
import android.content.Context;

import com.tihi.multiprocess.App;

/**
 * description:
 * author: duantianhui
 * date: 2017/2/21 9:43
 */

public class Util {

    /**
     * 得到当前进程名称
     * @return
     */
    public static String getCurProcessName() {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) App.instance().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

    /**
     * 打印当前系统运行进程信息
     */
    public static void printAllRunProcess() {
        ActivityManager manager = (ActivityManager) App.instance().getSystemService(Context.ACTIVITY_SERVICE);

        for(ActivityManager.RunningAppProcessInfo appProcess : manager.getRunningAppProcesses()) {
            String msg = appProcess.pid + ", " + appProcess.processName + ", " + appProcess.importance;
            if(appProcess.pkgList != null) {
                for(String pkg : appProcess.pkgList) {
                    msg += ", " + pkg;
                }
            }
            Logger.log(msg);
        }
    }

    /**
     * 当前线程名
     * @return
     */
    public static String curThread() {
        return Thread.currentThread().getName() + "_" + Thread.currentThread().getId() + "_" + Thread.currentThread().getState().name();
    }

    /**
     * 获取当前进程 和 线程
     * @return
     */
    public static void printCurProThr() {
        printCurProThr("");
    }

    /**
     * 获取当前进程 和 线程
     * @return
     */
    public static void printCurProThr(String msg) {
        Logger.log(msg + ", 当前进程和线程：" + getCurProcessName() + ", " + curThread());
    }


}
