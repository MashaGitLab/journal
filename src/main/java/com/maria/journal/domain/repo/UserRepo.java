package com.maria.journal.domain.repo;

import com.maria.journal.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
