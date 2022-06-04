package com.bootcamp.homework1.controller;

import com.bootcamp.homework1.entity.User;
import com.bootcamp.homework1.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepo userRepo;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> userList = userRepo.findAll();

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){

        User myUser = userRepo.findById(id).orElseThrow();

        return ResponseEntity.ok(myUser);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){

        user = userRepo.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){

        if (user.getId() == null){
            throw new RuntimeException("User id cannot be empty!");
        }

        boolean isExist = userRepo.existsById(user.getId());
        if (!isExist){
            throw new RuntimeException("Product does not exist!");
        }

        user = userRepo.save(user);

        return ResponseEntity.ok(user);
    }
    @PatchMapping("/passive/{id}")
    public ResponseEntity makePassive(@PathVariable Long id){

        User user = userRepo.findById(id).orElseThrow();

        user.setIsActive(Boolean.FALSE);

        user = userRepo.save(user);

        return ResponseEntity.ok(user);
    }

}
