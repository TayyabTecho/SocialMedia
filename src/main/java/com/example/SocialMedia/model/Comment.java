package com.example.SocialMedia.model;

import jakarta.persistence.*;

@Entity

public class Comment {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long commentId;
    String content;
    @ManyToOne
    public Post post;
    @ManyToOne
    public User user;

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
