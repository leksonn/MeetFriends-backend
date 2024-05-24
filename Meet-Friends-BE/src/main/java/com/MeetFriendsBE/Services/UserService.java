// src/main/java/com/MeetFriendsBE/Services/UserService.java
package com.MeetFriendsBE.Services;

import com.MeetFriendsBE.Models.User;
import com.MeetFriendsBE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(long id, User user) {
        Optional<User> current = userRepository.findById(id);
        if (!current.isPresent()) return null;
        User existingUser = current.get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User addToFriendsList(long userId, long friendId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<User> friendOpt = userRepository.findById(friendId);

        if (userOpt.isPresent() && friendOpt.isPresent()) {
            User user = userOpt.get();
            User friend = friendOpt.get();
            user.getFriendslist().add(friend);
            return userRepository.save(user);
        }
        return null;
    }

    public User removeFromFriendsList(long userId, long friendId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<User> friendOpt = userRepository.findById(friendId);

        if (userOpt.isPresent() && friendOpt.isPresent()) {
            User user = userOpt.get();
            User friend = friendOpt.get();
            user.getFriendslist().remove(friend);
            return userRepository.save(user);
        }
        return null;
    }
}
