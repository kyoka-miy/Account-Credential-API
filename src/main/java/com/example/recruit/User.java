package com.example.recruit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "userInfo")
public class User {
    @NotEmpty(message = "User Id is required")
    @Size(min=6, max=20, message = "User ID must be between 6 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "User ID must contain only letters and digits")
    @Id
    private String user_id;
    @Size(max=30, message = "Nickname must not exceed 30 characters")
    private String nickname;
    @Size(max=100, message = "Nickname must not exceed 100 characters")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;
    @Size(min=8, max=20, message = "Password must be between 8 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must contain only letters and digits")
    @NotEmpty(message = "Password is required")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public User() {
    }

    public User(String user_id, String nickname, String comment, String password) {
        this.user_id = user_id;
        this.nickname = nickname;
        this.comment = comment;
        this.password = password;
    }

    public User(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public User(String userId, String nickname, String comment) {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
