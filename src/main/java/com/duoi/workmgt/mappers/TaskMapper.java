package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.dto.TaskDTO;
import com.duoi.workmgt.respository.DayRepository;
import com.duoi.workmgt.respository.EmployeeRepository;
import com.duoi.workmgt.respository.ManagerRepository;
import com.duoi.workmgt.respository.TaskRepository;

import java.util.stream.Collectors;

public class TaskMapper {

    private DayRepository dayRepository;

    private ManagerRepository managerRepository;

    private EmployeeRepository employeeRepository;

    private TaskRepository taskRepository;

    public TaskDTO taskToTaskDTO(Task task) {
        return new TaskDTO(task);
    }

    //TODO
    public Task taskDTOToTask(TaskDTO taskDTO) {
        if (taskDTO == null)
            return null;
        return taskRepository.findById(taskDTO.getTaskId()).orElse(null);
    }
}