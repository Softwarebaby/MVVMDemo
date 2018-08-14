package com.qingcheng.du.app2.common;

import com.qingcheng.du.app2.di.AppComponent;

/**
 * Created by Bob Du on 2018/8/13 16:10
 */
public class ComponentHolder {

    private static AppComponent mComponent;

    public static AppComponent getComponent() {
        return mComponent;
    }

    public static void setComponent(AppComponent component) {
        mComponent = component;
    }
}
