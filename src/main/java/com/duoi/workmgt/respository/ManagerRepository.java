package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Manager;
import com.duoi.workmgt.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository extends CrudRepository<Manager, Long> {

    Optional<Manager> findByOrderedTasks(List<Task> orderedTasks);

}