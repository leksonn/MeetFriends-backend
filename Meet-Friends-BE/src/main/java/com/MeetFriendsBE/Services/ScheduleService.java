package com.MeetFriendsBE.Services;

import com.MeetFriendsBE.Models.Schedule;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private List<Schedule> schedulelist = new ArrayList<>();
    private long id = 0;

    public ScheduleService() {
        this.schedulelist.add(new Schedule(id++, LocalDateTime.of(2024, 5, 1, 12, 0), true));
        this.schedulelist.add(new Schedule(id++, LocalDateTime.of(2024, 5, 3, 19, 0), true));
        this.schedulelist.add(new Schedule(id++, LocalDateTime.of(2024, 5, 4, 16, 15), true));
    }

    public List<Schedule> getSchedules() {
        return this.schedulelist;
    }

    public List<Schedule> getUserSchedules(long id) {
        List<Schedule> singleUserSchedules = new ArrayList<>();
        for (Schedule schedule : this.schedulelist) {
            if (schedule.getUserId() == id) {
                singleUserSchedules.add(schedule);
            }
        }
        return singleUserSchedules;
    }

    public void deleteSchedule(Schedule scheduleToDelete) {
        for (Schedule schedule : this.schedulelist) {
            if (schedule == scheduleToDelete) {
                this.schedulelist.remove(schedule);
            }
        }
    }

    public void addSchedule(Schedule newSchedule) {
        for (Schedule schedule : this.schedulelist) {
            if (!((schedule.getUserId() == newSchedule.getUserId()) && (schedule.getScheduleTime() == newSchedule.getScheduleTime()))) {
                this.schedulelist.add(schedule);
            }
        }
    }

    public Schedule updateSchedule(Schedule update) {
        for (Schedule schedule : this.schedulelist) {
            if ((schedule.getScheduleTime() == update.getScheduleTime()) && (schedule.getUserId() == update.getUserId())) {
                this.schedulelist.get((int) schedule.getUserId()).setFilled(update.isFilled());
                return schedule;
            }
        }
        return null;
    }

}
