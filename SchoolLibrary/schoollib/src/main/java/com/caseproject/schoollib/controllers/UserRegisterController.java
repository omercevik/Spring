package com.caseproject.schoollib.controllers;

import com.caseproject.schoollib.dtos.UserDto;
import com.caseproject.schoollib.models.User;
import com.caseproject.schoollib.services.iservices.IUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class UserRegisterController {

    @Qualifier("userRegisterService")
    @Autowired
    private IUserRegisterService userRegisterService;


    @PostMapping("")
    public ResponseEntity<?> registerUser(@RequestBody UserDto regUser) {

        final boolean isExist = userRegisterService.existByEmail(regUser.getEmail());

        if (isExist)
            return new ResponseEntity<>("Error: 409 Conflict. Already exist!",HttpStatus.CONFLICT);

        if (regUser.getPassword() == null ||
        regUser.getFirstName() == null ||
        regUser.getLastName() == null)
            return new ResponseEntity<>("Error: 204 No Content.", HttpStatus.NO_CONTENT);

        User newUser = new User(regUser.getEmail(), regUser.getFirstName(), regUser.getLastName(), regUser.getPassword());
        userRegisterService.save(newUser);
        return new ResponseEntity<>(regUser, HttpStatus.CREATED);
    }
}
