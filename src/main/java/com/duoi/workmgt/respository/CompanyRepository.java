package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Long> {
}
