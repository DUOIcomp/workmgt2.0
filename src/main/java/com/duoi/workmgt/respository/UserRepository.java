package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUsername(String login);
}