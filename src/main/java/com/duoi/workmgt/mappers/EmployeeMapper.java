package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.dto.UserDTO;
import com.google.common.collect.Lists;

public class EmployeeMapper {

    public UserDTO employeeToUserDTO(Employee employee){
        return new UserDTO(employee);
    }

    public Employee userDTOToEmployee(UserDTO userDTO){
        if (userDTO == null)
            return null;
        else {
            Employee employee = new Employee();
            employee.setFirstName(userDTO.getFirstName());
            employee.setLastName(userDTO.getLastName());
            employee.setLogin(userDTO.getLogin());
            employee.setPassword(userDTO.getPassword());
            employee.setEmail(userDTO.getEmail());
            employee.setActivated(userDTO.isActivated());
            employee.setUserId(userDTO.getId());
            employee.setTasks(Lists.newArrayList());
            return employee;
        }
    }


}
