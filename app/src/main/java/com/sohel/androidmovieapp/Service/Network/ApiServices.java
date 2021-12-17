package com.sohel.androidmovieapp.Service.Network;

import com.sohel.androidmovieapp.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("3/movie/top_rated?api_key=9d38bd2aa655e6b6306b906d501f692c&language=en-US&page=1")
    Call<MovieModel> getAllTopRatedMovie();



}
