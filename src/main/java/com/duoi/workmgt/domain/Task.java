package com.duoi.workmgt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue
    private Long taskId;

    @ManyToOne(targetEntity = Day.class)
    private Day day;

    private String name;

    private String description;

    @ManyToMany
   // @Size(min = 1,message = "You must choose at least 1 employee")
    private List<Employee> employees = new ArrayList<>();

    @ManyToOne(targetEntity = Manager.class)
    @JoinColumn(name = "manager")
    private Manager manager;

    private LocalTime beginningOfTask;

    private LocalTime endOfTask;

}
