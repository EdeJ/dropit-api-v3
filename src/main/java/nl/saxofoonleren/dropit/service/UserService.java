package nl.saxofoonleren.dropit.service;

import nl.saxofoonleren.dropit.domain.Demo;
import nl.saxofoonleren.dropit.domain.User;
import nl.saxofoonleren.dropit.exceptions.DemoNotFoundException;
import nl.saxofoonleren.dropit.exceptions.UserNotFoundException;
import nl.saxofoonleren.dropit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new UserNotFoundException(userId);
        }
        return user.get();
    }

    public List<Demo> getDemosByUserId(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new UserNotFoundException(userId);
        }
        return user.get().getDemos();
    }
}
