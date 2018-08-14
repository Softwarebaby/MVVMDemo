package com.qingcheng.du.app2.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qingcheng.du.app2.R;
import com.qingcheng.du.app2.common.ComponentHolder;
import com.qingcheng.du.app2.databinding.ActivityMvvmBinding;
import com.qingcheng.du.app2.di.component.DaggerMvvmComponent;
import com.qingcheng.du.app2.di.component.MvvmComponent;
import com.qingcheng.du.app2.di.module.MvvmModule;
import com.qingcheng.du.app2.viewmodel.MvvmViewModel;

import javax.inject.Inject;

public class MvvmActivity extends BaseMvvmActivity<ActivityMvvmBinding, MvvmViewModel> {

    @Inject
    MvvmViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void inject() {
        MvvmComponent component = DaggerMvvmComponent.builder()
                .appComponent(ComponentHolder.getComponent())
                .mvvmModule(new MvvmModule(this))
                .build();
        component.injectActivity(this);
        component.injectViewModel(mViewModel);

        mBinding.setActivity(this);
        mBinding.setViewModel(mViewModel);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_mvvm;
    }
}
