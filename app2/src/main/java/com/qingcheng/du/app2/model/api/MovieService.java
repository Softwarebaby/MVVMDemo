package com.qingcheng.du.app2.model.api;

import com.qingcheng.du.app2.common.Constants;
import com.qingcheng.du.app2.model.MovieInfoModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Bob Du on 2018/8/13 15:29
 */
public interface MovieService {

    @GET(Constants.API.DOUBAN_MOVIE_INFO+"/{id}")
    Observable<MovieInfoModel> getMovieInfo(@Path("id") String movieId);
}
