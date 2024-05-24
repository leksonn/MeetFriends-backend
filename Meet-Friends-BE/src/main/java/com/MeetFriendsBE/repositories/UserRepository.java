package com.MeetFriendsBE.repositories;

import com.MeetFriendsBE.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
