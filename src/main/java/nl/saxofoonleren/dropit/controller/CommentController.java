package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private DemoRepository demoRepository;

    @GetMapping("/{demoId}")
    public ResponseEntity<?> getCommentByDemoId(@PathVariable("demoId") long demoId) throws IOException {
        Demo demo = demoRepository.findById(demoId).orElse(null);
        return ResponseEntity.ok(null);
    }


//    @GetMapping("/{commentId}")
//    public ResponseEntity<?> getCommentById(@PathVariable("commentId") long commentId) throws IOException {
////        Demo demo = demoRepository.findById(demoId).orElse(null);
//        return ResponseEntity.ok(null);
//    }
}
