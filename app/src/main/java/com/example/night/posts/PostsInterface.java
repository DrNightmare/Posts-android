package com.example.night.posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface PostsInterface {

    @GET("posts")
    Call<List<Post>> getPosts();
}
