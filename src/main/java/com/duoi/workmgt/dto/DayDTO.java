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

    public DayDTO(){
    }

    public DayDTO(Day day){
        this.id = day.getDayId();
        this.date = day.getDate();
        this.tasks = day.getTasks().stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "DayDTO{" +
                "id=" + id +
                ", date=" + date +
                ", tasks=" + tasks +
                '}';
    }
}
