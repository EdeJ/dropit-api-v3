package nl.saxofoonleren.dropit.service;

import nl.saxofoonleren.dropit.exceptions.DemoNotFoundException;
import nl.saxofoonleren.dropit.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public void deleteDemo(long demoId) {
        if(!demoRepository.existsById(demoId)) throw new DemoNotFoundException(demoId);
        demoRepository.deleteById(demoId);
    }

}
