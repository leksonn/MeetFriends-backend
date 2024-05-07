package com.MeetFriendsBE;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("streak")
@RestController
public class StreakController {

    private final StreakServices streakServices;

    public StreakController(StreakServices streakServices) {//a lot of this will be changed when the database is implemented
        this.streakServices = streakServices;
    }


    @GetMapping("all")
    public List<Streak> getStreaks() {
        return this.streakServices.getStreaks();
    }

    @DeleteMapping("delete")
    public void deleteStreak(@RequestBody String request) {
        this.streakServices.deleteStreak(request);
    }

    @PostMapping("add")
    public void createStreak(@RequestBody Streak streak) {
        this.streakServices.createStreak(streak);
    }

    @PutMapping("update")
    public void updateStreak(@RequestBody Streak streak) {
        this.streakServices.updateStreak(streak);
    }
}