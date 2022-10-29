package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment saveComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }
    @GetMapping
    public List<Comment> getAllComment() {
        return commentService.getAllComment();
    }
    @GetMapping("/findById")
    public List<Comment> getByCommentId(@RequestParam(name="commentId") String commentId){
        return commentService.getByCommentId(commentId);
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    @DeleteMapping
    public void deleteComment(@RequestParam(name="commentId") String commentId){
        commentService.deleteComment(commentId);
    }
}
