package com.MeetFriendsBE;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreakServices {

    private final List<Streak> streaks = new ArrayList<>();

    public StreakServices() {
        this.streaks.add(new Streak(7, "dzanof", "lekson"));
        this.streaks.add(new Streak(16, "dzanof", "barin"));
        this.streaks.add(new Streak(57, "dzanof", "hodzo"));
    }

    public List<Streak> getStreaks() {
        return this.streaks;
    }

    public void deleteStreak(String users) {
        String[] twoUsers = users.split(",");
        for (Streak streak : this.streaks) {
            if ((streak.getUser1().equals(twoUsers[0])) && (streak.getUser2().equals(twoUsers[1]))) {
                this.streaks.remove(streak);
            }
        }
    }

    public void createStreak(Streak newstreak) {
        this.streaks.add(newstreak);
    }

    public void updateStreak(Streak change) {
        for (Streak streak : this.streaks) {
            if ((streak.getUser1().equals(change.getUser1())) && (streak.getUser2().equals(change.getUser2()))) {
                streak.setStreak(change.getStreak());
            }
        }
    }

}
