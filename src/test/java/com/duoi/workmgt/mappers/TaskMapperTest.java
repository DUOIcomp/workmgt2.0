package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.dto.TaskDTO;
import com.duoi.workmgt.dto.UserDTO;
import com.duoi.workmgt.respository.DayRepository;
import com.duoi.workmgt.respository.TaskRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.stream.Collectors;

import static TestObjectFactory.Factory.createTestTask;
import static org.junit.Assert.*;

public class TaskMapperTest {

    private TaskMapper taskMapper;

    @Before
    public void setUp(){
        taskMapper = new TaskMapper();
    }

    @Test
    public void taskToTaskDTO() {
        Task task = createTestTask();

        TaskDTO taskDTO = taskMapper.taskToTaskDTO(task);

        Assert.assertEquals(task.getName(),taskDTO.getName());
        Assert.assertEquals(task.getTaskId(),taskDTO.getTaskId());
        Assert.assertEquals(task.getDescription(),taskDTO.getDescription());
        Assert.assertEquals(task.getBeginningOfTask(),taskDTO.getBeginningOfTask());
        Assert.assertEquals(task.getEndOfTask(),taskDTO.getEndOfTask());
        Assert.assertEquals(task.getEmployees().stream().map(UserDTO::new).collect(Collectors.toList()), taskDTO.getEmployees());
        Assert.assertEquals(new UserDTO(task.getManager()), taskDTO.getManager());

    }

    @Test
    public void taskDTOToTask() {
        Task task = createTestTask();

        TaskDTO taskDTO = taskMapper.taskToTaskDTO(task);
        Task testTask = taskMapper.taskDTOToTask(taskDTO);

        Assert.assertEquals(testTask, task);
    }
}