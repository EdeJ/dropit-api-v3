package nl.saxofoonleren.dropit.controller;

import nl.saxofoonleren.dropit.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/files")
public class FileController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("fileName") String fileName,
                                             @RequestParam("fileTitle") String fileTitel
    ) throws IOException {

        fileUploadService.uploadFile(file);
        System.out.println(fileName + " " + fileTitel);
//        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
    }

//    @PostMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
//        File convertFile = new File(file.getOriginalFilename())
//        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
//    }
}
