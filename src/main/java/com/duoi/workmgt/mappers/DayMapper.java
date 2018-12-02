package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.dto.DayDTO;
import java.util.stream.Collectors;

public class DayMapper {

    private final TaskMapper taskMapper;

    public DayMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public DayDTO dayToDayDTO(Day day){
        return new DayDTO(day);
    }

    public Day dayDTOtoDay(DayDTO dayDTO){
        if(dayDTO == null)
            return null;
        else{
            Day day = new Day();
            day.setDate(dayDTO.getDate());
            day.setDayId(dayDTO.getId());
            day.setTasks(
                    dayDTO.getTasks().stream()
                    .map(taskMapper::taskDTOToTask)
                    .collect(Collectors.toList())
            );
            return day;
        }
    }
}
