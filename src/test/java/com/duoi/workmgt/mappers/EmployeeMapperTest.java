package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.domain.User;
import com.duoi.workmgt.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;

import static TestObjectFactory.Factory.createTestEmployee;
import static org.junit.Assert.*;

public class EmployeeMapperTest {

    private EmployeeMapper employeeMapper = new EmployeeMapper();

    @Test
    public void employeeToUserDTO() {
        Employee employee = createTestEmployee();

        UserDTO employeeDTO = employeeMapper.employeeToUserDTO(employee);


        Assert.assertEquals(employee.getUserId(),employeeDTO.getId());
        Assert.assertEquals(employee.getEmail(),employeeDTO.getEmail());
        Assert.assertEquals(employee.getLogin(),employeeDTO.getLogin());
        Assert.assertEquals(employee.getFirstName(),employeeDTO.getFirstName());
        Assert.assertEquals(employee.getLastName(),employeeDTO.getLastName());
        Assert.assertEquals(employee.getPassword(),employeeDTO.getPassword());
    }

    @Test
    public void userDTOToEmployee() {
        Employee employee = createTestEmployee();
        UserDTO userDTO = employeeMapper.employeeToUserDTO(employee);

        Employee testEmployee = employeeMapper.userDTOToEmployee(userDTO);

        Assert.assertEquals(employee,testEmployee);
    }
}