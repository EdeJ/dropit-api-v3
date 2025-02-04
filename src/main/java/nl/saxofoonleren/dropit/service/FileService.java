package nl.saxofoonleren.dropit.service;

import nl.saxofoonleren.dropit.domain.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    DemoService demoService;

    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads/";

    public void uploadFile(MultipartFile file, Demo demo) throws IOException {
        UUID uuid = UUID.randomUUID();
        demo.setFileName(uuid + ".mp3");
        file.transferTo(new File(uploadDirectory + demo.getFileName()));
        demoService.saveDemo(demo);
    }

    public void deleteById(long demoId) {
        Demo demo = demoService.getDemoById(demoId);
        String fileName = demo.getFileName();

        File audioFile = new File(uploadDirectory + fileName);
        if (audioFile.delete()) {
            System.out.println("Deleted the file: " + audioFile.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
