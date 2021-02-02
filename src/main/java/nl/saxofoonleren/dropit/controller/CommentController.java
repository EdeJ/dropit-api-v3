package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Comment;
import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.payload.request.ReviewRequest;
import nl.saxofoonleren.dropit.service.DemoService;
import nl.saxofoonleren.dropit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    private DemoService demoService;


    @GetMapping
    public ResponseEntity<?> getAllComments() throws IOException {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @PostMapping
    public ResponseEntity<?> addNewComment(@RequestBody ReviewRequest reviewRequest) throws IOException {
        Demo demo = demoService.getDemoById(reviewRequest.getDemoId());
        Comment comment = new Comment();
        comment.setMessage(reviewRequest.getMessage());
        comment.setDemo(demo);
        commentService.saveComment(comment);
        return ResponseEntity.ok(comment);
    }

    @PutMapping(value = "/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable("commentId") long commentId,@RequestBody ReviewRequest reviewRequest) {
        Demo demo = demoService.getDemoById(reviewRequest.getDemoId());
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setMessage(reviewRequest.getMessage());
        comment.setDemo(demo);
        commentService.saveComment(comment);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable("id") long id) throws IOException {
        commentService.deleteComment(id);
        return ResponseEntity.ok("review " + id + " deleted");
    }


//    @GetMapping("/{commentId}")
//    public ResponseEntity<?> getCommentById(@PathVariable("commentId") long commentId) throws IOException {
////        Demo demo = demoRepository.findById(demoId).orElse(null);
//        return ResponseEntity.ok(null);
//    }
}
