package com.duoi.workmgt.respository;

import com.duoi.workmgt.domain.Day;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DayRepository extends CrudRepository<Day,Long> {

    List<Day> findAllByDate(LocalDate date);

}
