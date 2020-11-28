package com.caseproject.schoollib.services;

import com.caseproject.schoollib.models.User;
import com.caseproject.schoollib.repositories.UserRepository;
import com.caseproject.schoollib.services.iservices.IUserProfileManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileManagementService implements IUserProfileManService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User delete(User user) {
        userRepository.delete(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}