// src/main/java/com/MeetFriendsBE/DTOs/UserDTO.java
package com.MeetFriendsBE.DTOs;

import com.MeetFriendsBE.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String email;
    private List<User> friendslist;

}
