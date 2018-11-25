package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Company;
import com.duoi.workmgt.domain.Employee;
import com.duoi.workmgt.domain.Menager;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company,Long> {

    Optional<Company> findByCompanyName(String name);

    Optional<Company> findByEmployees(List<Employee> employees);

    Optional<Company> findByMenagers(List<Menager> menagers);

}
