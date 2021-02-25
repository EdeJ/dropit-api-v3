package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.domain.User;
import nl.saxofoonleren.dropit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "https://dropit.netlify.app", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() throws IOException {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") long userId) throws IOException {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUserById(@PathVariable long userId, @RequestBody User user) throws IOException {
        user.setUserId(userId);
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}/demos")
    public ResponseEntity<?> getDemosByUserId(@PathVariable("userId") long userId) throws IOException {
        List<Demo> demos = userService.getDemosByUserId(userId);
        return ResponseEntity.ok(demos);
    }

    @GetMapping("/check-up/{email}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("email") String email) throws IOException {
        User user = userService.getUserByUsername(email);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.getEmail(), HttpStatus.OK);
    }
}
