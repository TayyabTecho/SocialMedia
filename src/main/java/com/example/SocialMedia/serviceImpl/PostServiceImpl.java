package com.example.SocialMedia.serviceImpl;

import com.example.SocialMedia.model.Post;
import com.example.SocialMedia.model.User;
import com.example.SocialMedia.repository.PostRepository;
import com.example.SocialMedia.request.PostRequest;
import com.example.SocialMedia.response.PostResponse;
import com.example.SocialMedia.response.UserResponse;
import com.example.SocialMedia.service.PostService;
import com.example.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public void createPost(PostRequest postRequest) {
        Post post=new Post();
        post.setContent(postRequest.getContent());
    post.setTitle(postRequest.getTitle());
        postRepository.save(post);

    }

    @Override
    public PostResponse getPost(Long postId) {
        Post post=postRepository.findById(postId).orElseThrow(()->new RuntimeException("post id not found"));
    return new PostResponse(post);
    }

    @Override
    public List<PostResponse> getAllPost() {
        List<Post> all=postRepository.findAll();
        List<PostResponse> postResponses=new ArrayList<>();
        for (Post currentElement : all) {
            PostResponse postResponse = new PostResponse(currentElement);
            postResponses.add(postResponse);
        }
        return postResponses;
//        List<PostResponse> list = all.stream().map(PostResponse::new).toList();
//        return list;
    }

    @Override
    public PostResponse updatePostByPostId(Long postId, PostRequest postRequest) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("postid not found"));
        if (postRequest.getTitle() != null)
            post.setTitle(postRequest.getTitle());
        if (postRequest.getContent() != null)
            post.setContent(postRequest.getContent());

        Post save = postRepository.save(post);
        PostResponse obj1 = new PostResponse(save);
        return obj1;
    }
}
