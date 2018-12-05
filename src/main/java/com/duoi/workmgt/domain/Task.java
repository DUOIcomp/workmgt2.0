package com.duoi.workmgt.domain;

import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Task {
    @Id
    @GeneratedValue
    private Long taskId;

    private String name;

    private String description;

    @ManyToMany
    @Size(min = 1,message = "You must choose at least 1 employee")
    private List<Employee> employees = Lists.newArrayList();

    @ManyToOne(targetEntity = Manager.class)
    @JoinColumn(name = "manager")
    private Manager manager;

    private LocalTime beginningOfTask;

    private LocalTime endOfTask;


    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", employees=" + employees +
                ", manager=" + manager +
                ", beginningOfTask=" + beginningOfTask +
                ", endOfTask=" + endOfTask +
                '}';
    }
}
