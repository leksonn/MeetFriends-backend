package com.MeetFriendsBE.Services;

import com.MeetFriendsBE.Models.Request;
import com.MeetFriendsBE.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getRequests() {
        return requestRepository.findAll();
    }

    public Request getRequestById(long id) {
        return requestRepository.findById(id).orElse(null);
    }

    public void createRequest(Request newRequest) {
        requestRepository.save(newRequest);
    }

    public void updateRequest(Request updatedRequest) {
        if (requestRepository.existsById(updatedRequest.getId())) {
            requestRepository.save(updatedRequest);
        }
    }

    public void deleteRequest(long id) {
        if (requestRepository.existsById(id)) {
            requestRepository.deleteById(id);
        }
    }
}
