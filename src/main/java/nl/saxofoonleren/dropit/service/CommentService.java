package nl.saxofoonleren.dropit.service;

import nl.saxofoonleren.dropit.domain.Comment;
import nl.saxofoonleren.dropit.exceptions.CommentNotFoundException;
import nl.saxofoonleren.dropit.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(long id) {
        if (!commentRepository.existsById(id)) throw new CommentNotFoundException(id);
        commentRepository.deleteById(id);
    }
}
