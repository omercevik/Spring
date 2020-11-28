package com.caseproject.schoollib.controllers;

import com.caseproject.schoollib.dtos.UserDto;
import com.caseproject.schoollib.models.User;
import com.caseproject.schoollib.services.iservices.IUserProfileManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Qualifier("userProfileManagementService")
    @Autowired
    private IUserProfileManService userService;

    @PutMapping("")
    public ResponseEntity<?> updateProfile(@RequestBody UserDto userUpdate)
    {
        User user = userService.findByEmail(userUpdate.getEmail());
        if (user != null)
        {
            if (userUpdate.getFirstName() != null &&
                    userUpdate.getLastName() != null &&
                    userUpdate.getPassword() != null)
            {
                String password = userUpdate.getPassword();
                if (!user.getPassword().equals(password))
                    user.setPassword(password);
                if (!user.getFirstName().equals(userUpdate.getFirstName()))
                    user.setFirstName(userUpdate.getFirstName());
                if (!user.getLastName().equals(userUpdate.getLastName()))
                    user.setLastName(userUpdate.getLastName());
                userService.update(user);
                return new ResponseEntity<>(userUpdate,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(userUpdate, HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteUser(@RequestBody UserDto user) {
        User deleteUser = userService.findByEmail(user.getEmail());
        return userService.delete(deleteUser) != null ?
         new ResponseEntity<>("Successfully deleted!", HttpStatus.OK) : new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }
}
