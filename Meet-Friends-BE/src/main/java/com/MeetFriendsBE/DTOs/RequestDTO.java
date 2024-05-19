package com.MeetFriendsBE.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    private long id;
    private String sender;
    private String receiver;
    private String details;
    private String meetup_time;

}
