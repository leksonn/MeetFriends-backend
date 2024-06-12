package com.MeetFriendsBE.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreakDTO {   //yet another merge comment
    private Long id;
    private int streak;
    private String user1;
    private String user2;
}