// src/main/java/com/MeetFriendsBE/Controllers/UserController.java
package com.MeetFriendsBE.Controllers;

import com.MeetFriendsBE.DTOs.UserDTO;
import com.MeetFriendsBE.Models.User;
import com.MeetFriendsBE.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/login/{username}")
    public UserDTO login(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PutMapping("/{userId}/addFriend/{friendId}")
    public User addToFriendsList(@PathVariable long userId, @PathVariable long friendId) {
        return userService.addToFriendsList(userId, friendId);
    }

    @PutMapping("/{userId}/removeFriend/{friendId}")
    public User removeFromFriendsList(@PathVariable long userId, @PathVariable long friendId) {
        return userService.removeFromFriendsList(userId, friendId);
    }
}
