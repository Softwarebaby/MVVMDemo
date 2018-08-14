package com.qingcheng.du.app2.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.qingcheng.du.app2.common.Constants;
import com.qingcheng.du.app2.model.api.ServiceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bob Du on 2018/8/13 15:13
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context ProvideContext() {
        return context;
    }

    @Provides
    @Singleton
    SharedPreferences provideDefaultSp() {
        return context.getSharedPreferences(Constants.SP.DEFAULT_SP_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    ServiceManager provideMovieService() {
        return new ServiceManager();
    }
}
