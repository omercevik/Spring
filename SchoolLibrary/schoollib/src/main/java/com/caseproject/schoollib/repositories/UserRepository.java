package com.caseproject.schoollib.repositories;

import com.caseproject.schoollib.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}