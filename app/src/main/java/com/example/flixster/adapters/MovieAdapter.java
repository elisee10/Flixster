package com.example.flixster.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.DetailActivity;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import org.parceler.Parcels;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    //So we can inflate a view, where it is being constructed from
    Context context;
    //List of movies adapter need to hold on too
    List<Movie> movies;

    //constructor
    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    //Usually inflates a layout from XML and will return it in the holder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "OnCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);

    }

    @Override
    //Involved populating data into the item through the holder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter", "OnBindViewHolder"  + position);
        //get the movie at the position
        Movie movie = movies.get(position);
        //bind the movie data into the video holder
        holder.bind(movie);


    }

    @Override
    //Involves the total count of the items in the list
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        RelativeLayout container;
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            container = itemView.findViewById(R.id.container);



        }

        public void bind(final Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            String imageUrl;


            //If phone in landscape then change image  url to be backdrop image else if in potrait keep poster image
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

                //then imageUrl == backdrop image
                imageUrl=movie.getBackdropPath();

            } else {
                //else imageUrl ===Poster image
                imageUrl=movie.getPosterPath();
            }

            Glide.with(context).load(imageUrl).into(ivPoster);

            //1. Register click  listener on the whole row


            //2 Navigate to  a   new activity

            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //2. Navigate to a new activity on the tap
                    Intent i   = new Intent(context, DetailActivity.class);

                    //commenting out because we need all the necessary info about the movie, rathr than only the title
                    //i.putExtra("title", movie.getTitle());
                    i.putExtra("movie", Parcels.wrap(movie));
                    context.startActivity(i);
                }
            });
        }
    }
}
