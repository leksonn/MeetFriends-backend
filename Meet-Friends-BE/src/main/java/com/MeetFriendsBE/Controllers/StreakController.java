package com.MeetFriendsBE.Controllers;

import com.MeetFriendsBE.DTOs.StreakDTO;
import com.MeetFriendsBE.Services.StreakServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/streak")
public class StreakController {

    @Autowired
    private StreakServices streakServices;

    @GetMapping("/all")
    public List<StreakDTO> getStreaks() {
        return streakServices.getStreaks();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStreak(@PathVariable Long id) {
        streakServices.deleteStreak(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add")
    public StreakDTO createStreak(@RequestBody StreakDTO streakDTO) {
        return streakServices.createStreak(streakDTO);
    }

    @PutMapping("/update/{id}")
    public StreakDTO updateStreak(@PathVariable Long id) {
        return streakServices.updateStreak(id);
    }
}