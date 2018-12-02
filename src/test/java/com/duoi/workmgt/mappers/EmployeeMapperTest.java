package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Employee;
import org.junit.Test;

import static TestObjectFactory.Factory.createTestEmployee;
import static org.junit.Assert.*;

public class EmployeeMapperTest {

    @Test
    public void employeeToUserDTO() {
        Employee employee = createTestEmployee();
        System.out.println(employee);

        EmployeeMapper employeeMapper = new EmployeeMapper();
        System.out.println(employeeMapper.employeeToUserDTO(employee).toString());
    }

    @Test
    public void userDTOToEmployee() {
    }
}