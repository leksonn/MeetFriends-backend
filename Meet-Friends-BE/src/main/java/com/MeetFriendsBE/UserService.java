package com.MeetFriendsBE;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private long id=0;
    private List<User> users = new ArrayList<>();

    public UserService() {  //The way this data is structured may be changed after implementing the database
        this.users.add(new User(id++,"dzanooff","dzani"));
        this.users.add(new User(id++,"lekson","leki"));
        this.users.add(new User(id++,"doot","barin"));
    }
    List<User> getUsers () {
        return this.users;
    }

    User getUserById(Long id){
        for (User user : this.users) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    User deleteUserById(Long id){
        List<User> userList = this.users;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                this.users.remove(i);

            }
        }
        return null;
    }

    public User createUser(User user) { //later on, users won't be able to have the same username
        user.setId(this.id++);
        this.users.add(user);
        return null;
    }

    public User updateUser(long id,User user) {
        User current = this.getUserById(id);
        if (current==null) return null;
        current.setPassword(user.getPassword());
        current.setUsername(user.getUsername());
        return current;
    }
}