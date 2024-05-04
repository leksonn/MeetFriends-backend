package com.MeetFriendsBE;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private long id;
    private String Username;
    private String Password;
    private List<User> friendslist;

    public User(long id, String username, String password) {
        this.id=id;
        this.Username=username;
        this.Password=password;
    }

}