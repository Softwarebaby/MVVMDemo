package com.qingcheng.du.app2.common;

import com.qingcheng.du.app2.BuildConfig;

/**
 * Created by Bob Du on 2018/8/13 15:31
 */
public interface Constants {
    boolean DEBUG = BuildConfig.DEBUG;
    interface SP {
        String DEFAULT_SP_NAME = "preferences";
    }
    interface API {
        String BASE_DOUBAN = "https://api.douban.com";
        //GET 电影信息
        String DOUBAN_MOVIE_INFO = "/v2/movie/subject";
    }
}
