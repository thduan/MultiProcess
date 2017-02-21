package com.tihi.multiprocess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.lidroid.xutils.ViewUtils;

/**
 * description: 运行在主进程
 * author: duantianhui
 * date: 2017/2/21 11:23
 */

public class FourActivity extends FragmentActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, FourActivity.class));
    }
}
