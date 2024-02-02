package dev.ebank.contact.clients;

import dev.ebank.contact.model.classes.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "USER-SERVICE")
public interface UserCLientRest {
    @GetMapping("/users")
    @CircuitBreaker(name = "userService", fallbackMethod = "getAllUsers")
    List<User> allUsers();

    @GetMapping("/users/{id}")
    @CircuitBreaker(name = "userService", fallbackMethod = "getUser")
    User findUserById(@PathVariable Long id);

    default List<User> getAllUsers(Exception e){
    return List.of();
    }
    default User getUser(Long id, Exception e){
        User user= User.builder()
                .id(id)
                .firstname("not vailable")
                .lastname("not vailable")
                .email("not vailable")
                .active(true)
                .build();
        return user;

    }
}
