package dev.ebank.user.web;

import dev.ebank.user.model.entity.User;
import dev.ebank.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerRest {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public List<User> allUsers(){
     return   userRepository.findAll();
    }
    @PostMapping("/create")
    public User newUser(@RequestBody User user){
        return   userRepository.save(user);
    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        return   userRepository.findById(id).get();
    }
}
