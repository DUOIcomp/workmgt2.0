package com.duoi.workmgt.dto;

import com.duoi.workmgt.domain.Task;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TaskDTO {

    private Long taskId;

    @NotBlank
    private DayDTO day;

    private String name;

    private String description;

    @NotBlank
    private List<EmployeeDTO> employees;

    private ManagerDTO manager;

    @Pattern(regexp = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$",message = "IncorrectDateFormat")
    private String beginningOfTask;

    @Pattern(regexp = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$",message = "IncorrectDateFormat")
    private String endOfTask;

    TaskDTO(){
    }

    TaskDTO(Task task){
        this.taskId = task.getTaskId();
        this.day = new DayDTO(task.getDay());
        this.name = task.getName();
        this.description = task.getDescription();
        this.manager = new ManagerDTO(task.getManager());
        this.employees = task.getEmployees().stream()
                .map(employee -> new EmployeeDTO(employee))
                .collect(Collectors.toList());
        this.beginningOfTask = task.getBeginningOfTask().toString();
        this.endOfTask = task.getEndOfTask().toString();
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", day=" + day +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", employees=" + employees +
                ", menager=" + manager +
                ", beginningOfTask='" + beginningOfTask + '\'' +
                ", endOfTask='" + endOfTask + '\'' +
                '}';
    }
}
