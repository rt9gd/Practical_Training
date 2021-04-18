package com.example.mvvm.mvvm.model;


import android.os.SystemClock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.core.IModel;
import com.example.mvvm.mvvm.BaseRespEntity;
import com.example.mvvm.mvvm.model.service.entity.UserLoginEntity;

/**
 *
 */
public class UserLoginModel implements IModel {


    public LiveData<BaseRespEntity<UserLoginEntity>> login(UserLoginEntity entity){
        SystemClock.sleep(500);
        MutableLiveData<BaseRespEntity<UserLoginEntity>> result=new MutableLiveData<>();
        BaseRespEntity<UserLoginEntity> data = new BaseRespEntity<>();
        data.setCode(200);
        data.setData(new UserLoginEntity(1,"小明","123456"));
        result.setValue(data);
        return result;
    }

}
