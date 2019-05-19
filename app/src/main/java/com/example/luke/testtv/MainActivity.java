package com.example.luke.testtv;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {
    private RecyclerView movieList;
    private MovieListAdapter movieAdapter;

    public static final String EXTRA_MESSAGE = "com.example.luke.testtv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TV-节目列表");
        movieList = findViewById(R.id.main_recycler_movieList);
        movieAdapter = new MovieListAdapter();
        movieList.setLayoutManager(new LinearLayoutManager(this));//设置列表样式
        movieList.setAdapter(movieAdapter);
        movieList.addItemDecoration(
                new DividerItemDecoration(
                        this, DividerItemDecoration.VERTICAL
                )
        );
        movieAdapter.setOnItemClickListener(new MovieListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {//窗口跳转，跳转到播放页面
                Intent intent = new Intent(MainActivity.this, TvAction.class);
                intent.putExtra("name", MovieLab.get().getTv(position));
                startActivity(intent);
            }
        });
    }}