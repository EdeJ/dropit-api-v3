package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.User;
import nl.saxofoonleren.dropit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{userId}/demos")
    public ResponseEntity<?> getDemosByUserId(@PathVariable("userId") long userId) throws IOException {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            return ResponseEntity.ok("userId: " + userId + "not found!");
        }
        return ResponseEntity.ok(user.get().getDemos());
    }
}
