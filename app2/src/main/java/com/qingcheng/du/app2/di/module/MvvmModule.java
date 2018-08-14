package com.qingcheng.du.app2.di.module;

import com.qingcheng.du.app2.view.MvvmActivity;
import com.qingcheng.du.app2.viewmodel.MvvmViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bob Du on 2018/8/13 17:27
 */
@Module
public class MvvmModule {
    private MvvmActivity activity;
    public MvvmModule(MvvmActivity activity) {
        this.activity = activity;
    }

    @Provides
    MvvmActivity providesMvvmActivity() {
        return activity;
    }

    @Provides
    MvvmViewModel provideMvvmViewModel() {
        return new MvvmViewModel();
    }
}
