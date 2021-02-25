package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.domain.User;
import nl.saxofoonleren.dropit.service.FileService;
import nl.saxofoonleren.dropit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@CrossOrigin(origins = "https://dropit.netlify.app", maxAge = 3600)
@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("userId") long userId,
                                             Demo demo) throws IOException {

        User user = userService.getUserById(userId);
        demo.setUser(user);

        fileService.uploadFile(file, demo);
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
    }

    @GetMapping("/{mp3}")
    public ResponseEntity<Object> downLoadFile(@PathVariable("mp3") String mp3) throws IOException {

        String fileName = fileService.uploadDirectory + mp3;
        System.out.println(fileName);
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();

        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("audio/mpeg")).body(resource);

        return responseEntity;
    }

}


















