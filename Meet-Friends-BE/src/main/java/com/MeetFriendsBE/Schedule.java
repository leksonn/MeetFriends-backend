package com.MeetFriendsBE;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    private long userId; // this will be implemented better after all branches are connected on main
    private LocalDateTime scheduleTime;
    private boolean isFilled;


}
