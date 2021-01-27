package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.domain.User;
import nl.saxofoonleren.dropit.repository.DemoRepository;
import nl.saxofoonleren.dropit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/demos")
public class DemoController {

    @Autowired
    DemoRepository demoRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllDemos() {
        List<Demo> allDemos = demoRepository.findAll();
        return ResponseEntity.ok(allDemos);

    }

    @GetMapping("/{demoId}")
    public ResponseEntity<?> getDemoById(@PathVariable("demoId") long demoId) throws IOException {
        Demo demo = demoRepository.findById(demoId).orElse(null);
        System.out.println(demo);
        return ResponseEntity.ok(demo);
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<?> getDemosByUserId(@PathVariable("userId") long userId) throws IOException {
        User user = userRepository.findById(userId).orElse(null);
        List<Demo> demos = demoRepository.findDemosByUser(user);
        return ResponseEntity.ok(demos);
    }

}


















