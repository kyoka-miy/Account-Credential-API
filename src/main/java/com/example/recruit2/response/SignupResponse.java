package com.example.recruit2.response;

import com.example.recruit2.User;

import java.util.Optional;

public class SignupResponse {
    private String message;
    private Optional<User> user;

    public SignupResponse(String message, Optional<User> user) {
        this.message = message;
        this.user = user;
    }

    public SignupResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Optional<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = Optional.ofNullable(user);
    }
}
