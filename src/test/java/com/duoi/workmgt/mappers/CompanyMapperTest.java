package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Company;
import com.duoi.workmgt.dto.CompanyDTO;
import org.junit.Test;

import static TestObjectFactory.Factory.createTestCompany;
import static org.junit.Assert.*;

public class CompanyMapperTest {

    @Test
    public void companyToCompanyDTO() {
        Company company = createTestCompany();

        System.out.println(company);

        CompanyMapper companyMapper = new CompanyMapper();

        CompanyDTO companyDTO = companyMapper.companyToCompanyDTO(company);

        System.out.println(companyDTO);
    }

    @Test
    public void companyDTOToCompany() {
    }
}