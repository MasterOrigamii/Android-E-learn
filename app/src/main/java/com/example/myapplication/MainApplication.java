package com.example.myapplication;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.mob.MobSDK;
import com.example.myapplication.dao.DatabaseHelper;
import com.example.myapplication.utlis.SpUtil;


public class MainApplication extends Application {

    private static final String TAG = MainApplication.class.getName();

    private static MainApplication mApplication;

    public static synchronized MainApplication getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        MobSDK.init(this);
        //必须调用初始化
        OkGo.getInstance().init(this);
        DatabaseHelper.getInstance(this);
        SpUtil.init(this);
    }

}
