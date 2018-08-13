package com.qingcheng.du.mvvmdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.qingcheng.du.mvvmdemo.BR;

public class UserModel extends BaseObservable{
    private String username;
    private String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public int checkLogin() {
        if(username == null || password == null || username.isEmpty() || password.isEmpty())
            return -1;
        return 0;
    }

}
