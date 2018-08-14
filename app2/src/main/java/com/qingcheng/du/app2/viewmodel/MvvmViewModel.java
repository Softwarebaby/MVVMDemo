package com.qingcheng.du.app2.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.qingcheng.du.app2.model.MovieInfoModel;
import com.qingcheng.du.app2.model.Student;
import com.qingcheng.du.app2.model.api.ServiceManager;
import com.qingcheng.du.app2.view.MvvmActivity;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Bob Du on 2018/8/13 16:43
 */
public class MvvmViewModel extends BaseViewModel {
    public final ObservableField<Student> student = new ObservableField<>();
    public final ObservableField<MovieInfoModel> movieInfo = new ObservableField<>();

    @Inject
    MvvmActivity activity;
    @Inject
    SharedPreferences sp;
    @Inject
    Context context;
    @Inject
    ServiceManager serviceManager;

    public MvvmViewModel() {
        student.set(new Student("Bob", 21));
    }

    public void changeName() {
        Toast.makeText(context, "修改学生姓名！", Toast.LENGTH_SHORT).show();
        student.get().name.set(student.get().name.get() + "X");
    }

    /**
     * 网络请求电影信息
     */
    public void getMovieInfo() {
//        Toast.makeText(context, "请求电影信息！", Toast.LENGTH_SHORT).show();
        serviceManager.getMovieInfoTest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieInfoModel -> movieInfo.set(movieInfoModel));
    }
}
