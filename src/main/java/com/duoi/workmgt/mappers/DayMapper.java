package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.dto.DayDTO;
import com.duoi.workmgt.respository.TaskRepository;
import java.util.stream.Collectors;

public class DayMapper {

    private static TaskRepository taskRepository;

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
                    .map(taskDTO -> taskRepository.findById(taskDTO.getTaskId()).orElse(null))
                    .filter(task -> (task != null))
                            .collect(Collectors.toList())
            );
            return day;
        }
    }
}
