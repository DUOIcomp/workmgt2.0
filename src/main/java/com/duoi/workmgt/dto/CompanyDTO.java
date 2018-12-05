package com.duoi.workmgt.dto;

import com.duoi.workmgt.domain.Company;
import com.duoi.workmgt.domain.User;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class CompanyDTO {

    private Long id;

    private String companyName;


    private List<DayDTO> calendar = Lists.newArrayList();


    private List<UserDTO> managers = Lists.newArrayList();


    private List<UserDTO> employees = Lists.newArrayList();


    public CompanyDTO() {
    }

    public CompanyDTO(Long id, String companyName, List<DayDTO> calendar, List<UserDTO> managers, List<UserDTO> employees) {
        this.id = id;
        this.companyName = companyName;
        this.calendar = calendar;
        this.managers = managers;
        this.employees = employees;
    }

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.calendar = company.getCalendar().stream()
                    .map(DayDTO::new)
                    .collect(Collectors.toList());
        this.managers = company.getManagers().stream()
                    .map(UserDTO::new)
                    .collect(Collectors.toList());
        this.employees = company.getEmployees().stream()
                    .map(UserDTO::new)
                    .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                ", companyName='" + companyName + '\'' +
                ", calendar=" + calendar +
                ", managers=" + managers +
                ", employees=" + employees +
                '}';
    }
}
