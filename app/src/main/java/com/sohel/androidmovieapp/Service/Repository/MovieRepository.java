package com.sohel.androidmovieapp.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.sohel.androidmovieapp.Service.Model.MovieModel;
import com.sohel.androidmovieapp.Service.Model.Result;
import com.sohel.androidmovieapp.Service.Network.ApiServices;
import com.sohel.androidmovieapp.Service.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
   private MovieModel movieModel;
    private static Context mContext;
    private static MovieRepository movieRepository;
    private List<Result> mResult;
    private MutableLiveData mLiveData;
    public static  MovieRepository getInstance(Context context){
        mContext=context;
        if(movieRepository==null){
            movieRepository=new MovieRepository();
        }
        return movieRepository;
    }

    public MutableLiveData<List<Result>> getMovieList(){
        if(mLiveData==null){
            mLiveData=new MutableLiveData();
        }
        ApiServices apiServices= RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

        Call<MovieModel> call=apiServices.getAllTopRatedMovie();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                 movieModel=response.body();
                 mResult=movieModel.getResults();
                 mLiveData.postValue(mResult);
            }
            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        return mLiveData;
    }













}
