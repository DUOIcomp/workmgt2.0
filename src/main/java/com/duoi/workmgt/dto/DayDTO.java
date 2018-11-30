package com.duoi.workmgt.dto;

import com.duoi.workmgt.domain.Day;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DayDTO {

    private Long id;

    private LocalDate date;

    private List<TaskDTO> tasks;

    private CompanyDTO company;

    public DayDTO(){
    }

    public DayDTO(Day day){
        this.id = day.getId();
        this.date = day.getDate();
        this.tasks = day.getTasks().stream()
                .map(task -> new TaskDTO(task))
                .collect(Collectors.toList());
        this.company = new CompanyDTO(day.getCompany());
    }

    @Override
    public String toString() {
        return "DayDTO{" +
                ", date=" + date +
                ", tasks=" + tasks +
                '}';
    }
}
