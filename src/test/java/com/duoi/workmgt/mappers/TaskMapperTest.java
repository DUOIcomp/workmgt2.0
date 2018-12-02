package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.dto.TaskDTO;
import org.junit.Test;

import static TestObjectFactory.Factory.createTestTask;
import static org.junit.Assert.*;

public class TaskMapperTest {

    private TaskMapper taskMapper = new TaskMapper();

    @Test
    public void taskToTaskDTO() {
        Task task = createTestTask();

        System.out.println(task);
        System.out.println(taskMapper.taskToTaskDTO(task));
    }

    @Test
    public void taskDTOToTask() {
    }
}