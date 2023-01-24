package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    public void save(UserDTO req){
     repository.save(new User(req));
    }
    
}
