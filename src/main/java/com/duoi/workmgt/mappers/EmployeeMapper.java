package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.dto.UserDTO;

public class EmployeeMapper {

    public UserDTO employeeToUserDTO(Employee employee){
        return new UserDTO(employee);
    }

    //TODO
    public Employee userDTOToEmployee(UserDTO userDTO){
        return new Employee();
    }
}
