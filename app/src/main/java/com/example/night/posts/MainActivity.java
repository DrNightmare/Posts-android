package com.example.night.posts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    private PostsAdapter postsAdapter;
    private RecyclerView rvPosts;
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        rvPosts = (RecyclerView) findViewById(R.id.rvPosts);
        assert rvPosts != null;
        rvPosts.setHasFixedSize(true);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostsInterface postsInterface = retrofit.create(PostsInterface.class);

        Call<List<Post>> call = postsInterface.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> dummyPosts = response.body();
                postsAdapter = new PostsAdapter(getApplicationContext(), dummyPosts);
                rvPosts.setAdapter(postsAdapter);
                rvPosts.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
