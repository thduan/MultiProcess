package com.tihi.multiprocess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.tihi.multiprocess.Util.Logger;
import com.tihi.multiprocess.Util.Util;

/**
 * description:运行在子进程 thirdprocess
 * author: duantianhui
 * date: 2017/2/21 11:19
 */
@ContentView(R.layout.third_act)
public class ThirdActivity extends FragmentActivity{
    private static final String TAG_PREFIX = "ThirdActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        Util.printCurProThr(TAG_PREFIX);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, ThirdActivity.class));
    }

    /**
     * 全局变量测试，主进程修改后，子进程的静态变量取值 是否被改了
     * @param view
     */
    @OnClick(R.id.test_static_btn)
    private void testStatic(View view) {
        Logger.log(TAG_PREFIX + ", 全局静态变量值num为：" + Consts.num);
    }

}
