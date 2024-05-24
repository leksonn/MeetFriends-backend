// src/main/java/com/MeetFriendsBE/DTOs/UserDTO.java
package com.MeetFriendsBE.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String email;

}
