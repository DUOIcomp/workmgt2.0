package com.duoi.workmgt.service;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    void saveTask(TaskDTO taskDTO);
    Task readTaskById(Long id);
    Task readTaskByName(String name);
    List<Task> readTaskByDayAndEmployee(Employee employee, Day day);
    void deleteTask(Long taskId);
    void deleteAllTasks();
}
