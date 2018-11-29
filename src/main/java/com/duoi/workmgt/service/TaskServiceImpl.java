package com.duoi.workmgt.service;

import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.respository.DayRepository;
import com.duoi.workmgt.respository.EmployeeRepository;
import com.duoi.workmgt.respository.ManagerRepository;
import com.duoi.workmgt.respository.TaskRepository;
import com.duoi.workmgt.dto.TaskDTO;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.hibernate.ObjectNotFoundException;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    private final ManagerRepository managerRepository;

    private final EmployeeRepository employeeRepository;

    private final DayRepository dayRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ManagerRepository managerRepository, EmployeeRepository employeeRepository, DayRepository dayRepository) {
        this.taskRepository = taskRepository;
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
        this.dayRepository = dayRepository;
    }

    @Override
    @Transactional(rollbackOn = {MessagingException.class,ObjectNotFoundException.class})
    public void saveTask(TaskDTO taskDTO) {
            Task task = Task.builder()
                    .name(taskDTO.getName())
                    .day(dayRepository.findById(taskDTO.getDay().getId()).orElse(null))
                    .description(taskDTO.getDescription())
                    .beginningOfTask(LocalTime.parse(taskDTO.getBeginningOfTask()))
                    .endOfTask(LocalTime.parse(taskDTO.getEndOfTask()))
                    .manager(managerRepository.findById(taskDTO.getManager().getId()).orElse(null))
                    .employees(taskDTO.getEmployees().stream()
                                    .map(employeeDTO -> employeeRepository.findById(employeeDTO.getId()).orElse(null))
                                    .collect(Collectors.toList())
                            )
                    .build();

            taskRepository.save(task);
    }

    @Override
    public Task readTaskById(Long id) {
        Task foundTask = taskRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Task.class,"taskId"));

        return foundTask;
    }

    @Override
    public Task readTaskByName(String name) {
        Task foundTask = taskRepository.findByName(name)
                .orElseThrow(()-> new ObjectNotFoundException(Task.class,"taskName"));

        return foundTask;
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }
}

