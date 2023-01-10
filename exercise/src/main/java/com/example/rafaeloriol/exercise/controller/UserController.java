package com.example.rafaeloriol.exercise.controller;

import com.example.rafaeloriol.exercise.model.User;
import com.example.rafaeloriol.exercise.service.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById (@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);

        if(userOptional.isPresent()){
            return ResponseEntity.ok().body(userOptional.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser (@RequestBody User user) throws URISyntaxException {
        if (user.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User userDB = userService.createUser(user);
        return ResponseEntity.created(new URI("/api/users/" + userDB.getId())).body(userDB);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser (@RequestBody User user) throws URISyntaxException {
        if (user.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> deleteUsers () {
        userService.deleteUsers();
        return ResponseEntity.noContent().build();
    }

}
