package nl.saxofoonleren.dropit.service;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.exceptions.DemoNotFoundException;
import nl.saxofoonleren.dropit.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    @Autowired
    FileService fileService;

    public List<Demo> getAllDemos() {
        return demoRepository.findAll();
    }

    public Demo getDemoById(long demoId) {
        Optional<Demo> demo = demoRepository.findById(demoId);
        if (!demo.isPresent()) {
            throw new DemoNotFoundException(demoId);
        }
        return demo.get();
    }

    public void deleteDemo(long demoId) {
        if (!demoRepository.existsById(demoId)) throw new DemoNotFoundException(demoId);
        fileService.deleteById(demoId);
        demoRepository.deleteById(demoId);
    }

    public void saveDemo(Demo demo) {
        demoRepository.save(demo);
    }

}
