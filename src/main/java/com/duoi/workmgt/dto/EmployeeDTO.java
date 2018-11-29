package com.duoi.workmgt.dto;

import com.duoi.workmgt.domain.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDTO extends UserDTO {

    private List<TaskDTO> tasks;

    public EmployeeDTO(Employee employee) {
        super(employee);
        this.tasks = employee.getTasks().stream()
                .map(task -> new TaskDTO(task))
                .collect(Collectors.toList());
    }
}
