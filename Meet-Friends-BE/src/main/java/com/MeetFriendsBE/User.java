package com.MeetFriendsBE;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String Username;
    private String Password;
    private List<User> friendslist=new ArrayList<>();

    public User(long id, String username, String password) {
        this.id=id;
        this.Username=username;
        this.Password=password;
        this.friendslist.add(new User());
    }

}