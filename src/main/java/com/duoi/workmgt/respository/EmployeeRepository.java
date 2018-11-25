package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.domain.Task;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByTasks(List<Task> tasks);
}