package com.example.mvvm.mvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.core.BaseViewModel;
import com.example.mvvm.mvvm.BaseRespEntity;
import com.example.mvvm.mvvm.model.service.entity.UserLoginEntity;
import com.example.mvvm.mvvm.repository.UserLoginRepository;

/**
 *
 */
public class UserLoginViewModel extends BaseViewModel<UserLoginRepository> {

    public UserLoginEntity reqUserEntity= new UserLoginEntity();

    public UserLoginViewModel(LifecycleOwner _owner){
        super(_owner);
    }

    @Override
    protected UserLoginRepository creatRepository() {
        return new UserLoginRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public void login(UserLoginEntity entity){
        //return mRepositiry.login(entity);
        mRepositiry.login(entity).observe(mOwner, new Observer<BaseRespEntity<UserLoginEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<UserLoginEntity> result) {
                Log.d("123", "onChanged: "+result.toString());
            }
        });
    }
}
