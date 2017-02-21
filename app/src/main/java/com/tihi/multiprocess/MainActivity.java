package com.tihi.multiprocess;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.tihi.multiprocess.Util.FastJson;
import com.tihi.multiprocess.Util.Logger;
import com.tihi.multiprocess.Util.SharedPreferencesUtil;
import com.tihi.multiprocess.Util.Util;
import com.tihi.multiprocess.bean.Person;

/**
 * 运行在主进程
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    private static final String TAG_PREFIX = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        Util.printCurProThr(TAG_PREFIX);

        init();
    }
    /**
     * 初始化
     */
    private void init() {
        Consts.num = 100; //在主进程，将全局变量值赋值为100
        Logger.log(TAG_PREFIX + ", 全局静态变量值num为：" + Consts.num);
    }

    //1测试 全局静态变量

    /**
     * 全局变量测试，打开 sec_act，运行在  :subprocess
     * 不同的进程 ，不共享 全局静态变量
     * @param view
     */
    @OnClick(R.id.test_static_btn1)
    private void testStatic1(View view) {
        SecActivity.startAct(MainActivity.this);
    }

    /**
     * 全局变量测试，打开 third_act，运行在  thirdprocess
     * @param view
     */
    @OnClick(R.id.test_static_btn2)
    private void testStatic2(View view) {
        ThirdActivity.start(MainActivity.this);
    }

    /**
     * 测试进程间intent传递参数
     * @param view
     */
    @OnClick(R.id.test_intent)
    private void testIntent(View view) {
        Person person = new Person("xiyi", "青华路", 10);
        SecActivity.startAct(MainActivity.this, FastJson.toJSONString(person));
    }

    @OnClick(R.id.test_share_btn)
    private void testShare(View view) {
        SharedPreferencesUtil.instance().save(SharedPreferencesUtil.Keys.DEMO_TEST_KEY, "thisIsATest");
        SecActivity.startAct(MainActivity.this);
    }

    @OnClick(R.id.test_db_btn)
    private void testDb(View view) {
    }
}
