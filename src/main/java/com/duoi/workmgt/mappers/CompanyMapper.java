package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Company;
import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.dto.CompanyDTO;

public class CompanyMapper {
    public CompanyDTO companyToCompanyDTO(Company company){
        return new CompanyDTO(company);
    }

    //TODO
    public Employee companyDTOToCompany(CompanyDTO companyDTO){
        return null;
    }
}
