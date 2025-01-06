package com.example.SocialMedia.response;

import com.example.SocialMedia.model.Post;



public class PostResponse {

        private   Long postId;
        private String title;
        private String content;
    public PostResponse(Post post) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    private String content;







}
