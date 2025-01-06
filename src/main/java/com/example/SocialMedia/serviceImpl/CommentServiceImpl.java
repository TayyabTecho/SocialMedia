package com.example.SocialMedia.serviceImpl;

import com.example.SocialMedia.model.Comment;
import com.example.SocialMedia.repository.CommentRepository;
import com.example.SocialMedia.request.CommentRequest;
import com.example.SocialMedia.response.CommentResponse;
import com.example.SocialMedia.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void createComment(CommentRequest commentRequest) {
    Comment comment=new Comment();
    comment.setContent(commentRequest.getContent());
   commentRepository.save(comment);
    }

    @Override
    public CommentResponse getCommentById(Long commentId) {
        Comment comment=commentRepository.findById(commentId).orElseThrow(()->new RuntimeException("commmentId not found"));
return new CommentResponse(comment);
    }

    @Override
    public List<CommentResponse> getAllComment() {
        List<Comment> all= commentRepository.findAll();
        List<CommentResponse> commentResponses=new ArrayList<>();
    for(Comment currentElement:all){
        CommentResponse commentResponse = new CommentResponse(currentElement);
        commentResponses.add(commentResponse);
    }
    return commentResponses;
    }

    @Override
    public CommentResponse updateCommentBycommentId(Long commentId, CommentRequest commentRequest) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("id not found"));
        if(commentRequest.getContent()!=null){
            comment.setContent(commentRequest.getContent());
        }
        Comment save = commentRepository.save(comment);
        CommentResponse commentResponse = new CommentResponse(save);
        return commentResponse;
    }
}
