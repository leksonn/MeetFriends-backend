package com.MeetFriendsBE.Controllers;


import com.MeetFriendsBE.Models.User;
import com.MeetFriendsBE.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("login/"+"{id}")
    public User getUserByIdd(@PathVariable long id) {
        return this.userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUsers(@PathVariable long id) {
        this.userService.deleteUserById(id);
    }

    @DeleteMapping("friendlist/"+"{id}")//doesnt work on postman for some reason, i might be sending the request wrong
    public void deleteFromFriendList(@PathVariable long id, @RequestBody long id2) {
        this.userService.deleteFromFriendsList(id, id2);
    }

    @PostMapping("add")
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);

    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        return this.userService.updateUser(id, user);
    }

   @PutMapping("friendlist/"+"{id}")
    public User updateFriendlist(@PathVariable long id, @RequestBody User user) {
        return this.userService.updateFriendlist(id, user);
    }
}