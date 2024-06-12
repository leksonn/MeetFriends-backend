package com.MeetFriendsBE.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleDTO {
    private long userId;
    private LocalDateTime scheduleTime;   //this comment has been added so that i could merge my branch properly
    private boolean isFilled;   //another merging comment
}