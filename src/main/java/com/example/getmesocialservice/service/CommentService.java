package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public List<Comment> getByCommentId(String commentId) {
        return commentRepository.findCommentById(commentId);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(String commentId) {
        commentRepository.deleteById(commentId);
    }
}
