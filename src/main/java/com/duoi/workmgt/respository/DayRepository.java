package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Company;
import com.duoi.workmgt.domain.Day;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DayRepository extends CrudRepository<Day,Long> {

    Optional<Day> findByDate(LocalDate date);

}
