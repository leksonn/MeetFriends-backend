package com.MeetFriendsBE.Services;

import com.MeetFriendsBE.Models.Request;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService {

    private List<Request> requests = new ArrayList<>();
    private long id = 0;

    public RequestService() {
        this.requests.add(new Request(id++, "dzanof", "lekson", "Ajmo na kafu u titu moramo mahalat", "06.05.2024 15:30:00"));
        this.requests.add(new Request(id++, "barin", "hodzo", "Ajmo izac da setamo", "07.05.2024 17:00:00"));
        this.requests.add(new Request(id++, "lekson", "hodzo", "Idemo u Walter", "10.05.2024 21:30:00"));
    }

    public List<Request> getRequests() {
        return this.requests;
    }

    public Request getRequestsById(long id) {
        for (Request request : this.requests) {
            if (request.getId() == id) return request;
        }
        return null;
    }

    public void createRequest(Request newRequest) {
        for (Request request : this.requests) {
            if (request.getId() == newRequest.getId()) System.out.println("Request allready exists");
            else this.requests.add(newRequest);
        }
    }

    public void updateRequest(Request update) {
        for (Request request : this.requests) {
            if (request.getId() == update.getId()) request = update;
        }
    }

    public void deleteRequest(long id) {
        for (Request request : this.requests) {
            if (request.getId() == id) this.requests.remove(request);
        }
    }


}