package com.example.SocialMedia.response;

import com.example.SocialMedia.model.User;



public class UserResponse {
    private Long userId;
    private String userName;
    private String password;
    private String email;

public UserResponse(User user){
    this.userId=user.getUserId();
    this.email=user.getEmail();
    this.userName=user.getUserName();
    this.password=user.getPassword();
}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
