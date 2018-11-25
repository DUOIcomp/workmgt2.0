package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Day;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface DayRepository extends CrudRepository<Day,Long> {

    List<Day> findAllByDate(LocalDate date);

}
