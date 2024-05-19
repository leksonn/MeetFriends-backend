package com.MeetFriendsBE.Controllers;


import com.MeetFriendsBE.Models.Schedule;
import com.MeetFriendsBE.Services.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("schedule")
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("all")
    public List<Schedule> getSchedules() {
        return this.scheduleService.getSchedules();
    }


    @GetMapping("{id}")
    public List<Schedule> getUserSchedules(@PathVariable long id) {
        return this.scheduleService.getUserSchedules(id);
    }

    @DeleteMapping("delete")
    public void deleteUsers(@RequestBody Schedule schedule) {
        this.scheduleService.deleteSchedule(schedule);
    }

    @PostMapping("add")
    public void createUser(@RequestBody Schedule schedule) {
        this.scheduleService.addSchedule(schedule);
    }

    @PutMapping("update")
    public Schedule updateUser(@RequestBody Schedule schedule) {
        return this.scheduleService.updateSchedule(schedule);
    }

}

