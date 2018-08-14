package com.qingcheng.du.app2.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.qingcheng.du.app2.model.api.ServiceManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bob Du on 2018/8/13 15:12
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    SharedPreferences sharedPreferences();
    Context context();
    ServiceManager serviceManager();
}
