package com.duoi.workmgt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private long id;

    private String companyName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private List<Day> calendar = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private List<Menager> menagers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private List<Task> tasks = new ArrayList<>();
}
