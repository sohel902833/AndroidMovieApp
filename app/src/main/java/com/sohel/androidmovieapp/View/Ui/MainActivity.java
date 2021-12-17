package com.sohel.androidmovieapp.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sohel.androidmovieapp.R;
import com.sohel.androidmovieapp.Service.Model.Result;
import com.sohel.androidmovieapp.View.Adapter.MovieListAdapter;
import com.sohel.androidmovieapp.ViewModel.MovieListViewModel;

import java.util.List;
import java.util.PrimitiveIterator;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieListViewModel mViewModel;
    private MovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mViewModel=new ViewModelProvider(this).get(MovieListViewModel.class);




        mViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                    movieListAdapter=new MovieListAdapter(results,MainActivity.this);
                    recyclerView.setAdapter(movieListAdapter);

            }
        });





    }
}