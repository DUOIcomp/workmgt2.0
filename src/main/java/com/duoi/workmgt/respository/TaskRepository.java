package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}