package com.caseproject.schoollib.services;

import com.caseproject.schoollib.models.User;
import com.caseproject.schoollib.repositories.UserRepository;
import com.caseproject.schoollib.services.iservices.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class UserLoginService implements IUserLoginService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findByEmail(username);
        if (user == null)
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Error : 404 Not Found!");
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}