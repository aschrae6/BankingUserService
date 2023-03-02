package com.monopolycapstone.controllers;

import com.monopolycapstone.models.User;
import com.monopolycapstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        HttpStatus respCode = user.getId() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(user, respCode);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        User update = userService.updateUser(user);
        HttpStatus respCode = update.getId() == 0 ? HttpStatus.UNPROCESSABLE_ENTITY : HttpStatus.OK;

        return new ResponseEntity<>(update, respCode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id) {
        boolean deleted = userService.deleteUser(id);
        HttpStatus respCode = deleted ? HttpStatus.NO_CONTENT : HttpStatus.UNPROCESSABLE_ENTITY;

        return new ResponseEntity<>(deleted, respCode);
    }
}
