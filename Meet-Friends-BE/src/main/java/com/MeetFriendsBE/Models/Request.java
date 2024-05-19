package com.MeetFriendsBE.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request")
public class Request {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String sender;

    @Column//this will probably be changed to user once implemented into main
    private String receiver;

    @Column
    private String details;

    @Column
    private String meetup_time;


}