package com.example.SocialMedia.response;

import com.example.SocialMedia.model.Comment;



public class CommentResponse {
    Long commentId;
    String content;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentResponse(Comment comment) {
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
    }

    //String content;
}


