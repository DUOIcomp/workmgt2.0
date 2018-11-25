package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}