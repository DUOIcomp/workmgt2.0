package com.duoi.workmgt.service;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.mappers.TaskMapper;
import com.duoi.workmgt.respository.DayRepository;
import com.duoi.workmgt.respository.EmployeeRepository;
import com.duoi.workmgt.respository.ManagerRepository;
import com.duoi.workmgt.respository.TaskRepository;
import com.duoi.workmgt.dto.TaskDTO;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.hibernate.ObjectNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    private final ManagerRepository managerRepository;

    private final EmployeeRepository employeeRepository;

    private final DayRepository dayRepository;

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ManagerRepository managerRepository, EmployeeRepository employeeRepository, DayRepository dayRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
        this.dayRepository = dayRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    @Transactional(rollbackOn = {MessagingException.class,ObjectNotFoundException.class})
    public void saveTask(TaskDTO taskDTO) {
        Task task = taskMapper.taskDTOToTask(taskDTO);
        taskRepository.save(task);
    }

    @Override
    public Task readTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Task.class,"taskId"));
    }

    @Override
    public Task readTaskByName(String name) {
        return taskRepository.findByName(name)
                .orElseThrow(()-> new ObjectNotFoundException(Task.class,"taskName"));
    }

    @Override
    public List<Task> readTaskEmployee(Employee employee) {
        return taskRepository.findAllByEmployeesContains(employee);
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

