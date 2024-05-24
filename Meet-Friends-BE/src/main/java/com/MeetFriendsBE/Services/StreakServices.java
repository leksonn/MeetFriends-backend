// src/main/java/com/MeetFriendsBE/Services/StreakServices.java
package com.MeetFriendsBE.Services;

import com.MeetFriendsBE.DTOs.StreakDTO;
import com.MeetFriendsBE.Models.Streak;
import com.MeetFriendsBE.repositories.StreakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StreakServices {

    @Autowired
    private StreakRepository streakRepository;

    public List<StreakDTO> getStreaks() {
        return streakRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void deleteStreak(Long id) {
        streakRepository.deleteById(id);
    }

    public StreakDTO createStreak(StreakDTO streakDTO) {
        Streak streak = convertToEntity(streakDTO);
        Streak createdStreak = streakRepository.save(streak);
        return convertToDTO(createdStreak);
    }

    public StreakDTO updateStreak(Long id) {
        Optional<Streak> current = streakRepository.findById(id);
        if (!current.isPresent()) return null;
        Streak existingStreak = current.get();
        existingStreak.setStreak(existingStreak.getStreak() + 1); // Increase streak by 1
        Streak updatedStreak = streakRepository.save(existingStreak);
        return convertToDTO(updatedStreak);
    }

    private StreakDTO convertToDTO(Streak streak) {
        StreakDTO streakDTO = new StreakDTO();
        streakDTO.setId(streak.getId());
        streakDTO.setStreak(streak.getStreak());
        streakDTO.setUser1(streak.getUser1());
        streakDTO.setUser2(streak.getUser2());
        return streakDTO;
    }

    private Streak convertToEntity(StreakDTO streakDTO) {
        Streak streak = new Streak();
        streak.setId(streakDTO.getId());
        streak.setStreak(streakDTO.getStreak());
        streak.setUser1(streakDTO.getUser1());
        streak.setUser2(streakDTO.getUser2());
        return streak;
    }
}
