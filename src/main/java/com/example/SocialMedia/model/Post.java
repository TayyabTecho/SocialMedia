package com.example.SocialMedia.model;

import jakarta.persistence.*;

@Entity
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private   Long postId;
    private String title;
   private String content;
    @ManyToOne
    public User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
