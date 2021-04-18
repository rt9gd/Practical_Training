package com.example.mvvm.mvvm.model.service.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 *
 */
public class UserLoginEntity extends BaseObservable {

    public int id;
    public String name;
    public String pwd;

    public UserLoginEntity() {
    }

    public UserLoginEntity(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        //notifyPropertyChanged(BR.id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserLoginEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
