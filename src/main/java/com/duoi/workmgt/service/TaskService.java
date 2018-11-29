package com.duoi.workmgt.service;

import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.dto.TaskDTO;

public interface TaskService {
    void saveTask(TaskDTO taskDTO);
    Task readTaskById(Long id);
    Task readTaskByName(String name);
    void deleteTask(Long taskId);
    void deleteAllTasks();
}
