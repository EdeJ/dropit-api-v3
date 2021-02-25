package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Comment;
import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.payload.request.CommentRequest;
import nl.saxofoonleren.dropit.service.DemoService;
import nl.saxofoonleren.dropit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "https://dropit.netlify.app", maxAge = 3600)
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    private DemoService demoService;


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllComments() throws IOException {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<?> getCommentById(@PathVariable("commentId") long commentId) throws IOException {
        return ResponseEntity.ok(commentService.getCommentById(commentId));
    }

    @PostMapping
    public ResponseEntity<?> addNewComment(@RequestBody CommentRequest commentRequest) throws IOException {
        Demo demo = demoService.getDemoById(commentRequest.getDemoId());
        Comment comment = new Comment();
        comment.setMessage(commentRequest.getMessage());
        comment.setDemo(demo);
        commentService.saveComment(comment);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable("commentId") long commentId,@RequestBody CommentRequest commentRequest) {
        Demo demo = demoService.getDemoById(commentRequest.getDemoId());
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setMessage(commentRequest.getMessage());
        comment.setViewed(commentRequest.isViewed());
        comment.setDemo(demo);
        commentService.saveComment(comment);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable("id") long id) throws IOException {
        commentService.deleteComment(id);
        return ResponseEntity.ok("comment " + id + " deleted");
    }

}
