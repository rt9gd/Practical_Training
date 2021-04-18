package com.example.mvvm.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.core.view.BaseMVVMAcyivity;
import com.example.mvvm.R;
import com.example.mvvm.mvvm.viewmodel.UserLoginViewModel;

//直行道 怡园风景
public class UserLoginActivity extends BaseMVVMAcyivity<UserLoginViewModel, UserLoginDataBinding> {


    @Override
    protected int getVariable() {
        //return BR.reData;
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_login;
    }

    @Override
    protected UserLoginViewModel creatViewModel() {
        return new UserLoginViewModel(this);
    }
}
