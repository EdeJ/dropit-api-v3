package nl.saxofoonleren.dropit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/wakeup")
    public ResponseEntity<?>home() {
            return ResponseEntity.ok("waking up");
    }

}


















