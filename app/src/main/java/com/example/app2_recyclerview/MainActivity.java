package com.example.app2_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.app2_recyclerview.Models.Movie;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.list1);
        this.layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Movie[] movies = {
                new Movie("Avatar", "Action", "2009"),
                new Movie("Avatar: Last Air Bender", "Fantasy, Anime", "2006"),
                new Movie("Using Java in Android", "R+", "2020")
        };
        adapter = new MovieAdapter(movies);
        recyclerView.setAdapter(adapter);
        Toast.makeText(this, "Selected: ", Toast.LENGTH_SHORT);
    }
}
