package com.MeetFriendsBE;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("U")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("G")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }
    @GetMapping("{id}")
    public User getUserById(@PathVariable long id){
        return this.userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUsers(@PathVariable long id){
        this.userService.deleteUserById(id);
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return this.userService.createUser(user);

    }
    @PutMapping("{id}")
    public User updateUser(@PathVariable long id,@RequestBody User user){
        return this.userService.updateUser(id,user);
    }
}