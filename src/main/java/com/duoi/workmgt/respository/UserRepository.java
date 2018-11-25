package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByFirstName(String name);

    Optional<User> findByLastName(String lastName);

    Optional<User> findByEmail(String email);

    List<User> findByActivated(boolean activated);

}