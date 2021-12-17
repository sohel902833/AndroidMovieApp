package com.sohel.androidmovieapp.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sohel.androidmovieapp.R;
import com.sohel.androidmovieapp.Service.Model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private List<Result> movieList;
    private Context context;

    public MovieListAdapter(List<Result> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.movie_single_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Result result=movieList.get(position);

            holder.titleTv.setText(""+result.getTitle());
            holder.releaseDateTv.setText(""+result.getReleaseDate());
            holder.ratingTv.setText(""+result.getVoteCount());


        Picasso.get().load("https://image.tmdb.org/t/p/w500"+result.getPosterPath()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return movieList==null?0:movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTv,ratingTv,releaseDateTv;
        private ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv=itemView.findViewById(R.id.movieTitleTextViewId);
            ratingTv=itemView.findViewById(R.id.movieRatingTextViewId);
            releaseDateTv=itemView.findViewById(R.id.movieReleaseDateTvId);
            imageView=itemView.findViewById(R.id.movieImageViewId);
        }
    }
}
