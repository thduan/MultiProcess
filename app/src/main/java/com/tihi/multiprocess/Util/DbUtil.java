package com.tihi.multiprocess.Util;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.tihi.multiprocess.App;

import java.util.List;

/**
 * description:
 * author: duantianhui
 * date: 2017/2/21 10:41
 */

public class DbUtil {
    private static DbUtil _instance;
    private static final String DB_FILE = "dbDemo.db";
    private static DbUtils dbUtils;

    public DbUtil() {
        init();
    }

    public static DbUtil instance() {
        if(_instance == null) {
            synchronized (_instance) {
                if(_instance == null) {
                    _instance = new DbUtil();
                }
            }
        }
        return _instance;
    }

    private void init() {
        DbUtils.DaoConfig config = new DbUtils.DaoConfig(App.instance());
        config.setDbName(DB_FILE);
        dbUtils = DbUtils.create(config);
        dbUtils.configAllowTransaction(true);
    }

    public static void save(Object entity) {
        try {
            dbUtils.save(entity);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public static<T> T findFrist(Class<T> cls) {
        try {
            return  dbUtils.findFirst(cls);
        } catch (DbException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static<T> List<T> findAll(Class<T> cls) {
        try {
            return dbUtils.findAll(cls);
        } catch (DbException e) {
            e.printStackTrace();
            return null;
        }
    }

}
