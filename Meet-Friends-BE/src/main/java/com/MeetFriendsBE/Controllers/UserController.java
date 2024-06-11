package com.MeetFriendsBE.Controllers;

import com.MeetFriendsBE.DTOs.UserDTO;
import com.MeetFriendsBE.Models.User;
import com.MeetFriendsBE.Services.UserService;
import com.MeetFriendsBE.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.createUser(user);
    }

    @PostMapping("/authenticate")
    public Map<String, String> createAuthenticationToken(@RequestBody UserDTO userDTO) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        } catch (Exception e) {
            System.out.println("authenticstion fsiled at user controller  "+ e.getMessage());
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(userDTO.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        System.out.println(jwt);

        Map<String, String> response = new HashMap<>();
        response.put("token", jwt);
        return response;
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
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
