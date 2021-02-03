package nl.saxofoonleren.dropit.service;

import nl.saxofoonleren.dropit.domain.Comment;
import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.exceptions.CommentNotFoundException;
import nl.saxofoonleren.dropit.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    DemoService demoService;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(long id) {

        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment == null) throw new CommentNotFoundException(id);
        System.out.println(comment.getDemo());
        return comment;
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(long id) {
        if (!commentRepository.existsById(id)) throw new CommentNotFoundException(id);
        Comment comment = commentRepository.findById(id).orElse(null);
        Demo demo = comment.getDemo();
        demo.setComment(null);
        commentRepository.deleteById(id);
    }
}
