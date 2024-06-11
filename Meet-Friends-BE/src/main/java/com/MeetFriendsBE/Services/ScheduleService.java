package com.MeetFriendsBE.Services;

import com.MeetFriendsBE.DTOs.ScheduleDTO;
import com.MeetFriendsBE.Models.Schedule;
import com.MeetFriendsBE.Models.User;
import com.MeetFriendsBE.repositories.ScheduleRepository;
import com.MeetFriendsBE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Schedule> getAllSchedules(Long userId) {
        return scheduleRepository.findByUserId(userId);
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public Schedule createSchedule(ScheduleDTO scheduleDTO, String username) {
        User user = userRepository.findByUsername(username);
        Schedule schedule = new Schedule();
        schedule.setUser(user);
        schedule.setScheduleTime(scheduleDTO.getScheduleTime());
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Long id, ScheduleDTO scheduleDTO) {
        Optional<Schedule> scheduleOptional = scheduleRepository.findById(id);
        if (!scheduleOptional.isPresent()) return null;
        Schedule schedule = scheduleOptional.get();
        schedule.setScheduleTime(scheduleDTO.getScheduleTime());
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
