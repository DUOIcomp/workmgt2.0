package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}