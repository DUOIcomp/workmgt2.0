package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.*;
import org.joda.time.LocalTime;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Optional<Task> findById(Long id);

    Optional<Task> findByName(String name);

    List<Task>  findAllByDay(Day day);

    List<Task> findAllByManager(Manager manager);

    List<Task> findAllByDayAndEmployeesContains(Day day,Employee employees);
}