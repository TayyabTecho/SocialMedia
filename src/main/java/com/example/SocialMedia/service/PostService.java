package com.example.SocialMedia.service;

import com.example.SocialMedia.request.PostRequest;
import com.example.SocialMedia.response.PostResponse;

import java.util.List;

public interface PostService {
    void createPost(PostRequest postRequest);

    PostResponse getPost(Long postId);

    List<PostResponse> getAllPost();

    PostResponse updatePostByPostId(Long postId, PostRequest postRequest);
}
