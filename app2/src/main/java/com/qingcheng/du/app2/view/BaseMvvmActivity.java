package com.qingcheng.du.app2.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qingcheng.du.app2.viewmodel.BaseViewModel;

/**
 * Created by Bob Du on 2018/8/13 16:28
 */
public abstract class BaseMvvmActivity<T extends ViewDataBinding, D extends BaseViewModel> extends AppCompatActivity{
    protected T mBinding;
    protected D mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        inject();
    }

    /**
     * 规范使用DataBinding
     * （当销毁Activity时，解除DataBinding的绑定）
     */
    @Override
    protected void onDestroy() {
        if(mBinding != null)
            mBinding.unbind();
        super.onDestroy();
    }

    protected void initDataBinding() {
        int layoutId = getLayoutRes();
        mBinding = DataBindingUtil.setContentView(this, layoutId);
    }

    /**
     * 初始化DataBinding和Dagger2依赖注入
     */
    protected abstract void inject();

    /**
     * 传入布局文件
     * @return  基类会自动生成对应的DataBinding供导出类使用
     */
    protected abstract int getLayoutRes();
}
