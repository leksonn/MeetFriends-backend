package com.MeetFriendsBE.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.MeetFriendsBE.Models.Request;

public interface RequestRepository extends JpaRepository<Request,Long> {
}