package com.MeetFriendsBE.Controllers;

import com.MeetFriendsBE.DTOs.StreakDTO;
import com.MeetFriendsBE.Models.Streak;
import com.MeetFriendsBE.Services.StreakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/streak")
@RestController
public class StreakController {

    @Autowired
    private StreakService streakService;

    @GetMapping("/all")
    public List<Streak> getAllStreaks() {
        return streakService.getAllStreaks();
    }

    @GetMapping("/{id}")
    public Streak getStreakById(@PathVariable Long id) {
        return streakService.getStreakById(id);
    }

    @PostMapping("/add")
    public Streak createStreak(@RequestBody StreakDTO streakDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return streakService.createStreak(streakDTO, userDetails.getUsername());
    }

    @PutMapping("/{id}")
    public Streak updateStreak(@PathVariable Long id, @RequestBody StreakDTO streakDTO) {
        return streakService.updateStreak(id, streakDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStreak(@PathVariable Long id) {
        streakService.deleteStreak(id);
    }
}
