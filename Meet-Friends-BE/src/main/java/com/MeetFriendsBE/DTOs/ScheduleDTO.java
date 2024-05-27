package com.MeetFriendsBE.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleDTO {
    private long userId;
    private LocalDateTime scheduleTime;
    private boolean isFilled;
}