package com.duoi.workmgt.domain;

import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return Objects.equals(getId(), company.getId()) &&
                Objects.equals(getCompanyName(), company.getCompanyName()) &&
                Objects.equals(getCalendar(), company.getCalendar()) &&
                Objects.equals(getManagers(), company.getManagers()) &&
                Objects.equals(getEmployees(), company.getEmployees());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getCompanyName(), getCalendar(), getManagers(), getEmployees());
    }
}
