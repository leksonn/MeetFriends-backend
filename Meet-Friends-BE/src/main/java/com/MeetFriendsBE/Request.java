package com.MeetFriendsBE;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private long id;
    private String sender;//this will probably be changed to user once implemented into main
    private String receiver;
    private String details;
    private String meetup_time;
    //private LocalDateTime meetup_time;     should be localdatetime


}