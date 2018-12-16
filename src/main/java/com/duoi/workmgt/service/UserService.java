package com.duoi.workmgt.service;

import com.duoi.workmgt.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getUsers();
    Optional<User> getUser(Long id);
    User createUser(User user);
    User findByUsername(String login);
}
