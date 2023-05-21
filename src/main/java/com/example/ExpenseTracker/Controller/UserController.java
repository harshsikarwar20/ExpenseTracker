package com.example.ExpenseTracker.Controller;

import com.example.ExpenseTracker.Model.User;
import com.example.ExpenseTracker.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("getUser")
    private ResponseEntity<List<User>> getUser(@Nullable @RequestParam Integer userId){
        List<User> response = service.getUser(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("signIn") // ✅
    private ResponseEntity<User> signIn(@Valid @RequestBody User user){
        User response = service.signIn(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("logIn") // ✅
    private ResponseEntity<String> login(@Valid @RequestParam String userName, @Valid @RequestParam String userPassword){
        String response = service.logIn(userName, userPassword);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("deleteUser") // ✅
    private ResponseEntity<String> deleteUser(@RequestParam Integer userId) {
        String response = service.deleteUser(userId);
        if (response == null)
            return new ResponseEntity<>("User not exist", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
}