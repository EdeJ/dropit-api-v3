package nl.saxofoonleren.dropit.repository;

import nl.saxofoonleren.dropit.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Demo, Long> {
}
