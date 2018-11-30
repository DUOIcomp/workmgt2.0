package com.duoi.workmgt.dto;

import com.duoi.workmgt.domain.Company;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CompanyDTO {

    private Long id;

    private String companyName;


    private List<DayDTO> calendar;


    private List<ManagerDTO> managers;


    private List<EmployeeDTO> employees;


    private List<TaskDTO> tasks;

    public CompanyDTO() {
    }

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.calendar = company.getCalendar().stream()
                    .map(day -> new DayDTO(day))
                    .collect(Collectors.toList());
        this.managers = company.getManagers().stream()
                    .map(menager -> new ManagerDTO(menager))
                    .collect(Collectors.toList());
        this.employees = company.getEmployees().stream()
                    .map(employee -> new EmployeeDTO(employee))
                    .collect(Collectors.toList());
        this.tasks = company.getTasks().stream()
                    .map(task -> new TaskDTO(task))
                    .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                ", companyName='" + companyName + '\'' +
                ", calendar=" + calendar +
                ", menagers=" + managers +
                ", employees=" + employees +
                ", tasks=" + tasks +
                '}';
    }
}
