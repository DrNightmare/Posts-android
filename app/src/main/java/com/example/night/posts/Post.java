package com.example.night.posts;

import java.util.HashMap;
import java.util.Map;

class Post {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    /**
     *
     * @return
     * The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The body
     */
    public String getBody() {
        return body;
    }

    /**
     *
     * @param body
     * The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

//    public static ArrayList<Post> createDummyPosts(int numPosts) {
//        ArrayList<Post> dummyPosts = new ArrayList<Post>();
//
//        for (int i = 1; i <= numPosts; i++) {
//            dummyPosts.add(new Post(1, i, "Title " + i, "Random post body " + i));
//        }
//
//        return dummyPosts;
//    }

}