package nl.saxofoonleren.dropit.service;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    DemoRepository demoRepository;

    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads/";

    public void uploadFile(MultipartFile file, Demo demo) throws IOException {
        UUID uuid=UUID.randomUUID();
        demo.setFileName(uuid + ".mp3");
        file.transferTo(new File(uploadDirectory + demo.getFileName()));
        demoRepository.save(demo);
    }
}
