package com.example.app2_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2_recyclerview.Models.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Movie[] movie1;
    private Context context;

    public MovieAdapter(Movie[] movie1) {
        this.movie1 = movie1;
    }
    //Class MoviewViewHolder
    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public TextView txtView1, txtView2, txtView3;

        public MovieViewHolder(@NonNull View itemView, TextView txtView1, TextView txtView2, TextView txtView3) {
            super(itemView);
            this.txtView1 = txtView1;
            this.txtView2 = txtView2;
            this.txtView3 = txtView3;
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView title, genre, release_year;
        View view;

        view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.movie1, parent, false);
        title = view.findViewById(R.id.title);
        genre = view.findViewById(R.id.genre);
        release_year = view.findViewById(R.id.release_year);
        context = parent.getContext();

        return new MovieViewHolder(view, title,genre,release_year);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position) {
        holder.txtView1.setText(movie1[position].getTitle());
        holder.txtView2.setText(movie1[position].getGenre());
        holder.txtView3.setText(movie1[position].getRelease_date());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Selected: " + movie1[position].getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movie1.length;
    }
}
