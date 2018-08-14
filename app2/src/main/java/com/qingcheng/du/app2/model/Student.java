package com.qingcheng.du.app2.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.qingcheng.du.app2.BR;

/**
 * Created by Bob Du on 2018/8/13 15:21
 */
public class Student extends BaseObservable {

    public Student(String name, int age) {
        this.name.set(name);
        this.age = age;
    }

    /**
     * ObservableObject 实现数据绑定
     */
    private int age;

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
    @Bindable
    public int getAge() {
        return age;
    }

    /**
     * ObservableFields 实现数据绑定（推荐）
     */
    public final ObservableField<String> name = new ObservableField<>();
}
