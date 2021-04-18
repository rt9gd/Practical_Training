package com.example.mvvm.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.mvvm.mvvm.BaseRespEntity;
import com.example.mvvm.mvvm.model.service.entity.UserLoginEntity;
import com.example.mvvm.mvvm.model.UserLoginModel;

/**
 *
 */
public class UserLoginRepository extends BaseRepository<UserLoginModel> {

    @Override
    protected UserLoginModel createModel() {
        return new UserLoginModel();
    }

    public LiveData<BaseRespEntity<UserLoginEntity>> login(UserLoginEntity entity){
        return mModel.login(entity);
    }
}
