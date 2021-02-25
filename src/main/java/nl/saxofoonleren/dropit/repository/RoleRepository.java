package nl.saxofoonleren.dropit.repository;

import nl.saxofoonleren.dropit.domain.ERole;
import nl.saxofoonleren.dropit.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
