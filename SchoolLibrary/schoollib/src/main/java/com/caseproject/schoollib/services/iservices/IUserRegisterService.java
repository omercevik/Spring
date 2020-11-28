package com.caseproject.schoollib.services.iservices;

import com.caseproject.schoollib.models.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRegisterService {
    User findByEmail(String email);
    User save(User user);
    boolean existByEmail(String email);
}
