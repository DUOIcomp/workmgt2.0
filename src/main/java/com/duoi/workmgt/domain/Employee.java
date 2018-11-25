package com.duoi.workmgt.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employee extends User {

    @ManyToMany(targetEntity = Task.class)
    private List<Task> tasks = new ArrayList<>();

}
