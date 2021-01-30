package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.repository.UserRepository;
import nl.saxofoonleren.dropit.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/demos")
public class DemoController {

    @Autowired
    DemoService demoService;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllDemos() {
        return ResponseEntity.ok(demoService.getAllDemos());
    }

    @GetMapping("/{demoId}")
    public ResponseEntity<?> getDemo(@PathVariable("demoId") long demoId) throws IOException {
    Demo demo = demoService.getDemoById(demoId);
        return ResponseEntity.ok(demo);
    }

    @DeleteMapping("/{demoId}")
    public ResponseEntity<?> deleteDemo(@PathVariable("demoId") long demoId) throws IOException {

        demoService.deleteDemo(demoId);
        return ResponseEntity.ok("demo " + demoId+ " deleted");
    }

//    @GetMapping("/by-user/{userId}")
//    public ResponseEntity<?> getDemosByUserId(@PathVariable("userId") long userId) throws IOException {
//        User user = userRepository.findById(userId).orElse(null);
//       List<Demo> demos = demoRepository.findDemosByUser(user);
//        List<Demo> demos = demoRepository.findDemosByUserId(userId);
//        return ResponseEntity.ok(null);
//    }

}


















