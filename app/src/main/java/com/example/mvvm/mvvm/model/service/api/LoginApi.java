package com.example.mvvm.mvvm.model.service.api;

import androidx.lifecycle.LiveData;

import com.example.mvvm.mvvm.BaseRespEntity;
import com.example.mvvm.mvvm.model.service.entity.LoginEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *
 */
public interface LoginApi {

    @POST("api/User/login")
    LiveData<BaseRespEntity<LoginEntity>> login(@Body LoginEntity entity);

}
