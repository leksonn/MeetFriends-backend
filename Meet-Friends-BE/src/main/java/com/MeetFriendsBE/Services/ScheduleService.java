package com.MeetFriendsBE.Services;

import com.MeetFriendsBE.DTOs.ScheduleDTO;
import com.MeetFriendsBE.Models.Schedule;
import com.MeetFriendsBE.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<ScheduleDTO> getSchedules() {
        return scheduleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<ScheduleDTO> getUserSchedules(long id) {
        return scheduleRepository.findAll().stream()
                .filter(schedule -> schedule.getUserId() == id)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteSchedule(long id) {
        scheduleRepository.deleteById(id);
    }

    public ScheduleDTO addSchedule(ScheduleDTO newScheduleDTO) {
        Schedule newSchedule = convertToEntity(newScheduleDTO);
        Schedule savedSchedule = scheduleRepository.save(newSchedule);
        return convertToDTO(savedSchedule);
    }

    public ScheduleDTO updateSchedule(ScheduleDTO updateDTO) {
        Optional<Schedule> current = scheduleRepository.findById(updateDTO.getUserId());
        if (!current.isPresent()) return null;
        Schedule existingSchedule = current.get();
        existingSchedule.setScheduleTime(updateDTO.getScheduleTime());
        existingSchedule.setFilled(updateDTO.isFilled());
        Schedule updatedSchedule = scheduleRepository.save(existingSchedule);
        return convertToDTO(updatedSchedule);
    }

    private ScheduleDTO convertToDTO(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setUserId(schedule.getUserId());
        scheduleDTO.setScheduleTime(schedule.getScheduleTime());
        scheduleDTO.setFilled(schedule.isFilled());
        return scheduleDTO;
    }

    private Schedule convertToEntity(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setUserId(scheduleDTO.getUserId());
        schedule.setScheduleTime(scheduleDTO.getScheduleTime());
        schedule.setFilled(scheduleDTO.isFilled());
        return schedule;
    }
}
