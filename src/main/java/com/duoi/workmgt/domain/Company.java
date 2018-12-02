package com.duoi.workmgt.domain;

import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String companyName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Day> calendar = Lists.newArrayList();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private List<Manager> managers = Lists.newArrayList();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private List<Employee> employees = Lists.newArrayList();


    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
