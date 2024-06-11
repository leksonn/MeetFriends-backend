package com.MeetFriendsBE.Services;

import com.MeetFriendsBE.DTOs.RequestDTO;
import com.MeetFriendsBE.Models.Request;
import com.MeetFriendsBE.Models.User;
import com.MeetFriendsBE.repositories.RequestRepository;
import com.MeetFriendsBE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request getRequestById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    public Request createRequest(RequestDTO requestDTO, String username) {
        User user = userRepository.findByUsername(username);
        Request request = new Request();
        request.setUser(user);
        request.setDetails(requestDTO.getDetails());
        return requestRepository.save(request);
    }

    public Request updateRequest(Long id, RequestDTO requestDTO) {
        Optional<Request> requestOptional = requestRepository.findById(id);
        if (!requestOptional.isPresent()) return null;
        Request request = requestOptional.get();
        request.setDetails(requestDTO.getDetails());
        return requestRepository.save(request);
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}
