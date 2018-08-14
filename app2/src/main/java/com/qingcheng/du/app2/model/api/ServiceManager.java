package com.qingcheng.du.app2.model.api;

import com.qingcheng.du.app2.common.Constants;
import com.qingcheng.du.app2.model.MovieInfoModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Bob Du on 2018/8/13 15:21
 */
public class ServiceManager {

    MovieService movieService;

    public ServiceManager() {
        init();
    }

    private void init() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if(Constants.DEBUG) {
            //日志打印拦截器（进行日志打印）
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        OkHttpClient client = builder.build();

        movieService = new Retrofit.Builder()
                .baseUrl(Constants.API.BASE_DOUBAN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(MovieService.class);
    }

    /**
     * 获取对应电影ID的电影信息
     * @param movieId
     * @return
     */
    public Observable<MovieInfoModel> getMovieInfo(String movieId) {
        return movieService.getMovieInfo(movieId);
    }

    public Observable<MovieInfoModel> getMovieInfoTest() {
        return getMovieInfo(String.valueOf(25937854));
    }
}
