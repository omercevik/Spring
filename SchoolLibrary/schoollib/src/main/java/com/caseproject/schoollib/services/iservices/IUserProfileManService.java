package com.caseproject.schoollib.services.iservices;

import com.caseproject.schoollib.models.User;

public interface IUserProfileManService {
    User update(User updateUser);
    User findByEmail(String email);
    User delete(User user);
}
