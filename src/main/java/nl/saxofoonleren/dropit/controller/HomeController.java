package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.domain.User;
import nl.saxofoonleren.dropit.repository.DemoRepository;
import nl.saxofoonleren.dropit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DemoRepository demoRepository;

    @GetMapping
    public String home() {
        return "<h1>Home Page</h1>";
    }

    @GetMapping("/{username}")
    public ResponseEntity<?>home(@PathVariable("username") String username) {
        Optional<User> user = userRepository.findByUsername(username);
//        List<Demo> demos = demoRepository.findAll();
//        return ResponseEntity.ok(demos);
            return ResponseEntity.ok(user);

//        return "<h1>HELLO "+username+" </h1>";
    }

}


















