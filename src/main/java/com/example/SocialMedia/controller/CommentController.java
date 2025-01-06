package com.example.SocialMedia.controller;

import com.example.SocialMedia.request.CommentRequest;
import com.example.SocialMedia.response.CommentResponse;
import com.example.SocialMedia.response.UserResponse;
import com.example.SocialMedia.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    public void createComment(@RequestBody CommentRequest commentRequest){
        commentService.createComment(commentRequest);
    }

    @GetMapping("/{commentId}")
    public CommentResponse getCommentById(@PathVariable Long commnetId){
        return commentService.getCommentById(commnetId);
    }

    @GetMapping("/")
    public List<CommentResponse> findAll(){
        return commentService.getAllComment();
    }

    @PutMapping("/updateById/{commentId}")
    public CommentResponse updateById(@PathVariable Long commentId, @RequestBody CommentRequest commentRequest){
       return commentService.updateCommentBycommentId(commentId,commentRequest);
    }
}
