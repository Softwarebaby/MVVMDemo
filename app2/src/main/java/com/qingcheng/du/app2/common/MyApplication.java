package com.qingcheng.du.app2.common;

import android.app.Application;

import com.qingcheng.du.app2.di.AppComponent;
import com.qingcheng.du.app2.di.AppModule;
import com.qingcheng.du.app2.di.DaggerAppComponent;

/**
 * Created by Bob Du on 2018/8/13 15:09
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        inject();
    }

    private void inject() {
        AppComponent component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        ComponentHolder.setComponent(component);
    }
}
