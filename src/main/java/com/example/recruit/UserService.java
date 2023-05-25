package com.example.recruit;

import com.example.recruit.exception.AccountCreationException;
import com.example.recruit.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public Optional<User> getUser(String id) throws UserNotFoundException {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("No User found");
        }
        return userRepository.findById(id);
    }

    public User createUser(User user) throws AccountCreationException {
        if (userRepository.existsById(user.getUser_id())) {
            throw new AccountCreationException("Already same user_id is used");
        }
        if(user.getNickname()==null || user.getNickname().trim().isEmpty()) {
            user.setNickname(user.getUser_id());
        }
        return userRepository.save(user);
    }

    public ResponseEntity<String> deleteAllUser() {
        userRepository.deleteAll();
        return ResponseEntity.ok().body("Account and user successfully removed");
    }

    public void deleteUser(String id) throws AccountCreationException {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("No User found");
        }
        userRepository.deleteById(id);
    }

    public User updateUser(String id, User user) throws AccountCreationException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) { throw new UserNotFoundException("No User found"); }
        if(user.getUser_id()!=null || user.getPassword()!=null) { throw new AccountCreationException("not updatable user_id and password");}
        if(user.getNickname()==null && user.getComment()==null) {
            throw new AccountCreationException("required nickname or comment");
        }
        if(user.getNickname()!=null) optionalUser.get().setNickname(user.getNickname());
        if(user.getComment()!=null) optionalUser.get().setComment(user.getComment());
        return userRepository.save(optionalUser.get());
    }
}
