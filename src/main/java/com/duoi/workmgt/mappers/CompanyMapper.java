package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Company;
import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.dto.CompanyDTO;

import java.util.stream.Collectors;

public class CompanyMapper {

    private ManagerMapper managerMapper = new ManagerMapper();

    private EmployeeMapper employeeMapper = new EmployeeMapper();

    private DayMapper dayMapper = new DayMapper();


    public CompanyDTO companyToCompanyDTO(Company company){
        return new CompanyDTO(company);
    }

    public Company companyDTOToCompany(CompanyDTO companyDTO){
        if(companyDTO==null)
            return null;
        else {
            Company company = new Company();
            company.setId(companyDTO.getId());
            company.setCompanyName(companyDTO.getCompanyName());
            company.setManagers(
                    companyDTO.getManagers().stream()
                        .map(userDTO -> managerMapper.userDTOToManager(userDTO))
                        .collect(Collectors.toList())
            );
            company.setEmployees(
                    companyDTO.getEmployees().stream()
                        .map(userDTO -> employeeMapper.userDTOToEmployee(userDTO))
                        .collect(Collectors.toList())
            );
            company.setCalendar(
                    companyDTO.getCalendar().stream()
                        .map(dayDTO -> dayMapper.dayDTOtoDay(dayDTO))
                        .collect(Collectors.toList())
            );

            return company;
        }
    }
}
