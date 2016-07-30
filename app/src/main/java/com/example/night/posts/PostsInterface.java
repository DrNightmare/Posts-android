package com.example.night.posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by night on 12/7/16.
 */
public interface PostsInterface {

    @GET("posts")
    Call<List<Post>> getPosts();
}
