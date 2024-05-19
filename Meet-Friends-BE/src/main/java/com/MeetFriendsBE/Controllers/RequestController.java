package com.MeetFriendsBE.Controllers;

import com.MeetFriendsBE.Models.Request;
import com.MeetFriendsBE.Services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<Request> getRequests() {
        return requestService.getRequests();
    }

    @GetMapping("/{id}")
    public Request getRequestById(@PathVariable long id) {
        return requestService.getRequestById(id);
    }

    @PostMapping
    public void createRequest(@RequestBody Request request) {
        requestService.createRequest(request);
    }

    @PutMapping
    public void updateRequest(@RequestBody Request request) {
        requestService.updateRequest(request);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable long id) {
        requestService.deleteRequest(id);
    }
}

