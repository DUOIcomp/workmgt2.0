package com.duoi.workmgt.repositroy;

import com.duoi.workmgt.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByUserId(Long var1);

    Optional<User> findOneByEmail(String var1);

    Optional<User> findOneByLogin(String var1);

    List<User> findAllByActivated(boolean var1);

    void deleteOneById(Long var1);

    void deleteOneByEmail(String var1);

    void deleteOneByLogin(String var1);
}