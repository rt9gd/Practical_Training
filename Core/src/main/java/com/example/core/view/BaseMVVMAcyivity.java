package com.example.core.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.core.BaseViewModel;

/**
 *
 */
public abstract class BaseMVVMAcyivity<VM extends BaseViewModel,V extends ViewDataBinding> extends BaseActivity{

    protected VM mViewModel;
    protected V mV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mV=DataBindingUtil.setContentView(this,getLayoutId());
        mV.setVariable(getVariable(),creatViewModel());
        mV.setLifecycleOwner(this);
    }

    protected abstract int getVariable();

    protected abstract int getLayoutId();

    protected abstract VM creatViewModel();
}
