package com.MeetFriendsBE.Controllers;

import com.MeetFriendsBE.Models.Request;
import com.MeetFriendsBE.Services.RequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("sentrequests")
@RestController
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("all")
    public List<Request> getRequests() {
        return this.requestService.getRequests();
    }

    @GetMapping("{id}")
    public Request getRequestById(@PathVariable long id) {
        return this.requestService.getRequestsById(id);
    }

    @PostMapping("add")
    public void createRequest(@RequestBody Request request) {
        this.requestService.createRequest(request);

    }

    @PutMapping("update")
    public void updateRequest(@RequestBody Request request){
        this.requestService.updateRequest(request);
    }

    @DeleteMapping("{id}")
    public void deleteRequest(@PathVariable long id){
        this.requestService.deleteRequest(id);
    }

}
