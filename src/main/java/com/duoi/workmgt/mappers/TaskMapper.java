package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.dto.TaskDTO;
import com.duoi.workmgt.respository.DayRepository;
import com.duoi.workmgt.respository.EmployeeRepository;
import com.duoi.workmgt.respository.ManagerRepository;

import java.util.stream.Collectors;

public class TaskMapper {

    private DayRepository dayRepository;

    private ManagerRepository managerRepository;

    private EmployeeRepository employeeRepository;


    public TaskDTO taskToTaskDTO(Task task){
        return new TaskDTO(task);
    }

    public Task taskDTOToTask(TaskDTO taskDTO){
        if(taskDTO == null)
            return null;
        else {
            Task task = new Task();
            task.setTaskId(taskDTO.getTaskId());
            task.setDay(dayRepository.findByDate(taskDTO.getDay()).orElse(null)); //TODO change null to createDay
            task.setName(taskDTO.getName());
            task.setDescription(taskDTO.getDescription());
            task.setEmployees(
                    taskDTO.getEmployees().stream()
                    .map(userDTO -> employeeRepository.findById(userDTO.getId()).orElse(null))
                            .filter(employee -> (employee!=null))
                    .collect(Collectors.toList())

            );
            task.setManager(managerRepository.findById(taskDTO.getManager().getId()).orElse(null));
            task.setEndOfTask(taskDTO.getEndOfTask());
            task.setBeginningOfTask(taskDTO.getBeginningOfTask());

            return task;
        }
    }

}
