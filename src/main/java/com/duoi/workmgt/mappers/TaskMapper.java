package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.dto.TaskDTO;

import java.util.stream.Collectors;

public class TaskMapper {

    private final EmployeeMapper employeeMapper = new EmployeeMapper();

    private final ManagerMapper managerMapper = new ManagerMapper();


    public TaskDTO taskToTaskDTO(Task task) {
        return new TaskDTO(task);
    }

    public Task taskDTOToTask(TaskDTO taskDTO) {
        if (taskDTO == null)
            return null;
        else{
            Task task = new Task();
            task.setName(taskDTO.getName());
            task.setEndOfTask(taskDTO.getEndOfTask());
            task.setBeginningOfTask(taskDTO.getBeginningOfTask());
            task.setDescription(taskDTO.getDescription());
            task.setTaskId(taskDTO.getTaskId());
            task.setManager(managerMapper.userDTOToManager(taskDTO.getManager()));
            task.setEmployees(taskDTO.getEmployees().stream()
                    .map(employeeMapper::userDTOToEmployee)
                    .collect(Collectors.toList()));
            return task;
        }
    }
}