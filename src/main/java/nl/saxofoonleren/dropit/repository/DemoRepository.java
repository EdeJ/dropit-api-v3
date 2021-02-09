package nl.saxofoonleren.dropit.repository;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoRepository extends JpaRepository<Demo, Long> {

    List<Demo> findDemosByUser(User user);
    List<Demo> findAllByOrderByUser();
    List<Demo> findAllByUserUserId(long userId);

}
