package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.domain.User;
import nl.saxofoonleren.dropit.repository.UserRepository;
import nl.saxofoonleren.dropit.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("userId") long userId,
                                             Demo demo) throws IOException {

        User user = userRepository.findById(userId).orElse(null);
            demo.setUser(user);

        fileService.uploadFile(file, demo);
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
    }

//    @PostMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
//        File convertFile = new File(file.getOriginalFilename())
//        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
//    }
}


















