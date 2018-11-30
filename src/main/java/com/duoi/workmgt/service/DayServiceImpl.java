package com.duoi.workmgt.service;

import com.duoi.workmgt.domain.Company;
import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.dto.DayDTO;
import com.duoi.workmgt.respository.CompanyRepository;
import com.duoi.workmgt.respository.DayRepository;
import com.duoi.workmgt.respository.TaskRepository;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.hibernate.ObjectNotFoundException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class DayServiceImpl implements DayService {

    private final TaskRepository taskRepository;

    private final DayRepository dayRepository;

    private final CompanyRepository companyRepository;

    public DayServiceImpl(TaskRepository taskRepository, DayRepository dayRepository, CompanyRepository companyRepository) {
        this.taskRepository = taskRepository;
        this.dayRepository = dayRepository;
        this.companyRepository = companyRepository;
    }


    @Override
    @Transactional(rollbackOn = {MessagingException.class,ObjectNotFoundException.class})
    public void saveDay(DayDTO dayDTO) {
        dayRepository.save(
                Day.builder()
                        .id(dayDTO.getId())
                        .date(dayDTO.getDate())
                        .tasks(dayDTO.getTasks().stream()
                                .map(taskDTO -> taskRepository.findById(taskDTO.getTaskId()).orElse(null))
                                .collect(Collectors.toList())
                        )
                        .company(companyRepository.findById(dayDTO.getCompany().getId()).orElse(null))
                .build()
        );
    }

    @Override
    public Day readDayById(Long id) {
        return dayRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Day.class,"dayId"));
    }

    @Override
    public Day readDayByCompanyIdAndDate(Company company, LocalDate date) {
        return dayRepository.findByCompanyAndDate(company,date)
                .orElseThrow(() -> new ObjectNotFoundException(Day.class,"CompanyAndDate"));
    }

    @Override
    public void deleteDay(Long dayId) {
        dayRepository.deleteById(dayId);
    }

    @Override
    public void deleteAllDays() {
        dayRepository.deleteAll();
    }
}
