package com.duoi.workmgt.dto;

import com.duoi.workmgt.domain.Task;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class TaskDTO {

    private Long taskId;

    private LocalDate day;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private List<UserDTO> employees = Lists.newArrayList();

    @NotBlank
    private UserDTO manager;

    @Pattern(regexp = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$",message = "IncorrectDateFormat")
    private LocalTime beginningOfTask;

    @Pattern(regexp = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$",message = "IncorrectDateFormat")
    private LocalTime endOfTask;

    TaskDTO(){
    }

    public TaskDTO(Task task){
        this.taskId = task.getTaskId();
        this.day = task.getDay().getDate();
        this.name = task.getName();
        this.description = task.getDescription();
        this.manager = new UserDTO(task.getManager());
        this.employees = task.getEmployees().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
        this.beginningOfTask = task.getBeginningOfTask();
        this.endOfTask = task.getEndOfTask();
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", day=" + day +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", employees=" + employees +
                ", manager=" + manager +
                ", beginningOfTask='" + beginningOfTask + '\'' +
                ", endOfTask='" + endOfTask + '\'' +
                '}';
    }
}
