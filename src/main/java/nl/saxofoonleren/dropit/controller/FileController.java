package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.domain.User;
import nl.saxofoonleren.dropit.repository.UserRepository;
import nl.saxofoonleren.dropit.service.FileService;
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


//    @GetMapping(value = "/data")
//    public ResponseEntity<StreamingResponseBody> streamData() {
//        StreamingResponseBody responseBody = response -> {
//            for (int i = 1; i <= 1000; i++) {
//                try {
//                    Thread.sleep(10);
//                    response.write(("Data stream line - " + i + "\n").getBytes());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        return ResponseEntity.ok()
//                .contentType(MediaType.TEXT_PLAIN)
//                .body(responseBody);
//    }


    @GetMapping("/{mp3}")
    public ResponseEntity<Object> downLoadFile(@PathVariable("mp3") String mp3) throws IOException {

//        "73dc25aa-6f0b-458b-88fc-c25e92f1837f-song.mp3";
        String fileName = fileService.uploadDirectory + mp3;
        System.out.println(fileName);
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition",
//                String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("audio/mpeg")).body(resource);

        return responseEntity;
    }

//    @PostMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
//        File convertFile = new File(file.getOriginalFilename())
//        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
//    }
}


















