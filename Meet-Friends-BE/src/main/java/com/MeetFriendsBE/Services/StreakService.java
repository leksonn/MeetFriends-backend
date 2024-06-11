package com.MeetFriendsBE.Services;

import com.MeetFriendsBE.DTOs.StreakDTO;
import com.MeetFriendsBE.Models.Streak;
import com.MeetFriendsBE.Models.User;
import com.MeetFriendsBE.repositories.StreakRepository;
import com.MeetFriendsBE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreakService {

    @Autowired
    private StreakRepository streakRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Streak> getAllStreaks() {
        return streakRepository.findAll();
    }

    public Streak getStreakById(Long id) {
        return streakRepository.findById(id).orElse(null);
    }

    public Streak createStreak(StreakDTO streakDTO, String username) {
        User user = userRepository.findByUsername(username);
        Streak streak = new Streak();
        streak.setUser(user);
        streak.setStreak(streakDTO.getStreak());
        return streakRepository.save(streak);
    }

    public Streak updateStreak(Long id, StreakDTO streakDTO) {
        Optional<Streak> streakOptional = streakRepository.findById(id);
        if (!streakOptional.isPresent()) return null;
        Streak streak = streakOptional.get();
        streak.setStreak(streakDTO.getStreak());
        return streakRepository.save(streak);
    }

    public void deleteStreak(Long id) {
        streakRepository.deleteById(id);
    }
}
