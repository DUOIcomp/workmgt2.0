package com.duoi.workmgt.service;

import com.duoi.workmgt.domain.Company;
import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.dto.DayDTO;

import java.time.LocalDate;

public interface DayService {
    void saveDay(DayDTO dayDTO);
    Day readDayById(Long id);
    Day readDayByCompanyIdAndDate(Company company, LocalDate date);
    void deleteDay(Long dayId);
    void deleteAllDays();
}
