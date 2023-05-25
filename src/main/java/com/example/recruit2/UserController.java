package com.example.recruit2;

import com.example.recruit2.exception.AccountCreationException;
import com.example.recruit2.response.SignupResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@Valid @RequestBody User user) throws AccountCreationException {
        User createdUser = userService.createUser(user);
        SignupResponse response = new SignupResponse("Account successfully created", Optional.ofNullable(createdUser));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<SignupResponse> getUserById(@PathVariable("user_id") String userId) throws AccountCreationException {
        Optional<User> gotUser = userService.getUser(userId);
        SignupResponse response = new SignupResponse("User details by user_id", gotUser);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllUsers() {
        userService.deleteAllUser();
    }

    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable("user_id") String userId) throws AccountCreationException {
        userService.deleteUser(userId);
        SignupResponse response = new SignupResponse("User successfully removed");
        return ResponseEntity.ok(response.getMessage());
    }

    @PatchMapping("/users/{user_id}")
    public ResponseEntity<SignupResponse> updateUser(@PathVariable("user_id") String userId, @RequestBody User user) throws AccountCreationException {
        User updatedUser = userService.updateUser(userId, user);
        SignupResponse response = new SignupResponse("User successfully updated", Optional.ofNullable(updatedUser));
        return ResponseEntity.ok(response);
    }
}
