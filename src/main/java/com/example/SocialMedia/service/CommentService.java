package com.example.SocialMedia.service;

import com.example.SocialMedia.request.CommentRequest;
import com.example.SocialMedia.response.CommentResponse;

import java.util.List;

public interface CommentService {
    void createComment(CommentRequest commentRequest);

    CommentResponse getCommentById(Long commnetId);

    List<CommentResponse> getAllComment();

    CommentResponse updateCommentBycommentId(Long commentId, CommentRequest commentRequest);
}
