package com.MeetFriendsBE.Controllers;

import com.MeetFriendsBE.DTOs.RequestDTO;
import com.MeetFriendsBE.Models.Request;
import com.MeetFriendsBE.Services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/request")
@RestController
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/all")
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public Request getRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @PostMapping("/add")
    public Request createRequest(@RequestBody RequestDTO requestDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return requestService.createRequest(requestDTO, userDetails.getUsername());
    }

    @PutMapping("/{id}")
    public Request updateRequest(@PathVariable Long id, @RequestBody RequestDTO requestDTO) {
        return requestService.updateRequest(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
    }
}
