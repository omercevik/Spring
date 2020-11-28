package com.caseproject.schoollib.services;

import com.caseproject.schoollib.models.User;
import com.caseproject.schoollib.repositories.UserRepository;
import com.caseproject.schoollib.services.iservices.IUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService implements IUserRegisterService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user){
        User newUser = new User(user.getEmail(), user.getFirstName(),
                user.getLastName(), user.getPassword());
        return userRepository.save(newUser);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}