package com.MeetFriendsBE.Controllers;

import com.MeetFriendsBE.DTOs.ScheduleDTO;
import com.MeetFriendsBE.Services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/all")
    public List<ScheduleDTO> getSchedules() {
        return scheduleService.getSchedules();
    }

    @GetMapping("/{id}")
    public List<ScheduleDTO> getUserSchedules(@PathVariable long id) {
        return scheduleService.getUserSchedules(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add")
    public ScheduleDTO addSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.addSchedule(scheduleDTO);
    }

    @PutMapping("/update")
    public ScheduleDTO updateSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.updateSchedule(scheduleDTO);
    }
}

