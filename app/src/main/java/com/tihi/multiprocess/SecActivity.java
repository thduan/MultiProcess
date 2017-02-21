package com.tihi.multiprocess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.tihi.multiprocess.Util.FastJson;
import com.tihi.multiprocess.Util.Logger;
import com.tihi.multiprocess.Util.SharedPreferencesUtil;
import com.tihi.multiprocess.Util.Util;
import com.tihi.multiprocess.bean.Person;

/**
 * description: 运行在子进程 :subprocesss
 * author: duantianhui
 * date: 2017/2/21 9:41
 */

@ContentView(R.layout.sec_act)
public class SecActivity extends FragmentActivity{

    private static final String TAG_PREFIX = "SecActivity";
    private static final String INTENT_PENSON_KEY = "person_key";

    private Person person;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        init();
        Util.printCurProThr(TAG_PREFIX);
    }

    private void init() {
        if(getIntent() != null) {
            String personJson = getIntent().getStringExtra(INTENT_PENSON_KEY);
            if(!TextUtils.isEmpty(personJson)) {
                person = FastJson.parseObject(personJson, Person.class);
                //测试跨进程，Intent能否正确传递数据
                Logger.log(TAG_PREFIX + ", 跨进程intent能正确传递数据， person: " + personJson);
            }

        }
    }

    public static void startAct(Context context) {
        context.startActivity(new Intent(context, SecActivity.class));
    }

    public static void startAct(Context context, String personJson) {
        Intent intent = new Intent(context, SecActivity.class);
        intent.putExtra(INTENT_PENSON_KEY, personJson);
        context.startActivity(intent);
    }

    /**
     * 全局变量测试，主进程修改后，子进程的静态变量取值 是否被改了
     * @param view
     */
    @OnClick(R.id.test_static_btn)
    private void testStatic(View view) {
        Logger.log(TAG_PREFIX + ", 全局静态变量值num为：" + Consts.num);
    }

    @OnClick(R.id.test_share_btn)
    private void testShare(View view) {
        Logger.log(TAG_PREFIX + ", share值：" + SharedPreferencesUtil.get(SharedPreferencesUtil.Keys.DEMO_TEST_KEY));
    }

    @OnClick(R.id.test_act_process_btn)
    private void testActProcess(View view) {
        ThirdActivity.start(SecActivity.this);
    }
}
