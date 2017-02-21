package com.tihi.multiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * description:
 * author: duantianhui
 * date: 2017/2/21 9:41
 */

public class LocationService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
