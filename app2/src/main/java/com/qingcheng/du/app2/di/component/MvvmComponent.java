package com.qingcheng.du.app2.di.component;

import com.qingcheng.du.app2.di.AppComponent;
import com.qingcheng.du.app2.di.module.MvvmModule;
import com.qingcheng.du.app2.di.scope.ActivityScope;
import com.qingcheng.du.app2.view.MvvmActivity;
import com.qingcheng.du.app2.viewmodel.MvvmViewModel;

import dagger.Component;

/**
 * Created by Bob Du on 2018/8/13 17:31
 */
@ActivityScope
@Component(modules = MvvmModule.class, dependencies = AppComponent.class)
public interface MvvmComponent {
    void injectActivity(MvvmActivity activity);
    void injectViewModel(MvvmViewModel viewModel);
}
