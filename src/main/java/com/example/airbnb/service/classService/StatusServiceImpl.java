package com.example.airbnb.service.classService;

import com.example.airbnb.model.Status;
import com.example.airbnb.repository.StatusRepository;
import com.example.airbnb.service.interfaceS.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;
    @Override
    public Iterable<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<Status> findById(Long id) {
        return statusRepository.findById(id);
    }

    @Override
    public void save(Status status) {

    }

    @Override
    public void remove(Long id) {

    }
}
