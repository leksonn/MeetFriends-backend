package com.MeetFriendsBE.repositories;

import com.MeetFriendsBE.Models.Streak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreakRepository extends JpaRepository<Streak, Long> {
}