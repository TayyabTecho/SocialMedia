package com.example.SocialMedia.service;

import com.example.SocialMedia.request.UserRequest;
import com.example.SocialMedia.response.UserResponse;

import java.util.List;

public interface UserService {
     void createUser(UserRequest userRequest);

    UserResponse getUser(Long userId);

    List<UserResponse> getAllUser();

    UserResponse updateUserByUserId(Long userId, UserRequest userRequest);
}

