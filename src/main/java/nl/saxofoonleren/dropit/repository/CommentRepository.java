package nl.saxofoonleren.dropit.repository;

import nl.saxofoonleren.dropit.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
