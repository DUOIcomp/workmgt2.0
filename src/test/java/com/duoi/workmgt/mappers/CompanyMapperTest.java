package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Company;
import com.duoi.workmgt.dto.CompanyDTO;
import com.duoi.workmgt.dto.DayDTO;
import com.duoi.workmgt.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

import static TestObjectFactory.Factory.createTestCompany;
import static org.junit.Assert.*;

public class CompanyMapperTest {

    private CompanyMapper companyMapper = new CompanyMapper();

    @Test
    public void companyToCompanyDTO() {
        Company company = createTestCompany();

        CompanyDTO companyDTO = companyMapper.companyToCompanyDTO(company);

        Assert.assertEquals(company.getId(),companyDTO.getId());
        Assert.assertEquals(company.getCompanyName(),companyDTO.getCompanyName());
        Assert.assertEquals(company.getCalendar().stream().map(DayDTO::new).collect(Collectors.toList()),companyDTO.getCalendar());
        Assert.assertEquals(company.getEmployees().stream().map(UserDTO::new).collect(Collectors.toList()),companyDTO.getEmployees());
        Assert.assertEquals(company.getManagers().stream().map(UserDTO::new).collect(Collectors.toList()),companyDTO.getManagers());

    }

    @Test
    public void companyDTOToCompany() {
        Company company = createTestCompany();
        CompanyDTO companyDTO = companyMapper.companyToCompanyDTO(company);

        Company testCompany = companyMapper.companyDTOToCompany(companyDTO);

        Assert.assertEquals(company,testCompany);
    }
}