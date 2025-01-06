package com.example.SocialMedia.serviceImpl;
import com.example.SocialMedia.model.User;
import com.example.SocialMedia.repository.UserRepository;
import com.example.SocialMedia.request.UserRequest;
import com.example.SocialMedia.response.UserResponse;
import com.example.SocialMedia.service.UserService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository
            userRepository;

    @Override
    public void createUser(UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);
   }
    @Override
    public UserResponse getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("id not found"));
        return new UserResponse(user);
    }
    @Override
    public List<UserResponse> getAllUser() {
        List<User> all = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User currentElement : all) {
            UserResponse userResponse = new UserResponse(currentElement);
            userResponses.add(userResponse);
        }
        return userResponses;
//        List<UserResponse> list = all.stream().map(UserResponse::new).toList();
//        return list;

    }

    @Override
    public UserResponse updateUserByUserId(Long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("id not found"));
        if (userRequest.getUserName() != null)
            user.setUserName(userRequest.getUserName());
        if (userRequest.getPassword() != null)
            user.setPassword(userRequest.getPassword());
        if (userRequest.getEmail() != null)
            user.setEmail(userRequest.getEmail());
        User save = userRepository.save(user);
        UserResponse obj = new UserResponse(save);
        return obj;
    }
}
