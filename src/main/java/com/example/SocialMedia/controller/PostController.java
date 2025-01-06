package com.example.SocialMedia.controller;

import com.example.SocialMedia.request.PostRequest;
import com.example.SocialMedia.response.PostResponse;
import com.example.SocialMedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/")
    public void createPost(@RequestBody PostRequest postRequest){
        postService.createPost(postRequest);
    }

    @GetMapping("/{postId}")
    public PostResponse findById(@PathVariable Long postId){
        return postService.getPost(postId);
    }

    @GetMapping("/")
    public List<PostResponse> findAll(){
        return postService.getAllPost();
    }

    @PutMapping("/updateById/{postId}")
    public PostResponse updateById(@PathVariable Long postId, @RequestBody PostRequest postRequest){
        return postService.updatePostByPostId(postId,postRequest);
    }
}
