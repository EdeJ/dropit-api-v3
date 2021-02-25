package nl.saxofoonleren.dropit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://dropit.netlify.app/", maxAge = 3600)
@RestController
@RequestMapping("api/home")
public class HomeController {

    // this end-point in only used to wake up the sleeping heroku server
    @GetMapping("/wake-up")
    public ResponseEntity<?>wakeUp() {
            return ResponseEntity.ok("waking up!");
    }

}


















