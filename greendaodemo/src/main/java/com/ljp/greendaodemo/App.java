package com.ljp.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.facebook.stetho.Stetho;
import com.ljp.greendaodemo.db.MyOpenHelper;
import com.ljp.greendaodemo.greendao.DaoMaster;
import com.ljp.greendaodemo.greendao.DaoSession;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class App extends Application {

    DaoSession mDaoSession;
    DaoMaster mDaoMaster;
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;

    private static final String DB_NAME = "test.db";

    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Stetho.initializeWithDefaults(this);
        setDatabase();
    }

    public static App getInstance(){
        return instance;
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
//        mHelper = new DaoMaster.DevOpenHelper(this, "sport-db", null);
//        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        MyOpenHelper helper = new MyOpenHelper(this,"sport-db",null);
        mDaoMaster = new DaoMaster(helper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }

}
