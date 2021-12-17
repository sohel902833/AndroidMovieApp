package com.sohel.androidmovieapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sohel.androidmovieapp.Service.Model.Result;
import com.sohel.androidmovieapp.Service.Repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {
    private MovieRepository mRepo;
    public MovieListViewModel(@NonNull Application application) {
        super(application);
        mRepo=MovieRepository.getInstance(application);
    }
    public MutableLiveData<List<Result>> getTopRatedMovieList(){
        return mRepo.getMovieList();
    }








}
