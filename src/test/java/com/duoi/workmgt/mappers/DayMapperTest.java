package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.dto.DayDTO;
import com.duoi.workmgt.dto.TaskDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

import static TestObjectFactory.Factory.createTestDay;
import static org.junit.Assert.*;

public class DayMapperTest {

    private DayMapper dayMapper = new DayMapper();

    @Test
    public void dayToDayDTO() {
        Day day = createTestDay();

        DayDTO dayDTO = dayMapper.dayToDayDTO(day);

        Assert.assertEquals(day.getDate(),dayDTO.getDate());
        Assert.assertEquals(day.getDayId(),dayDTO.getId());
        Assert.assertEquals(day.getTasks().stream().map(TaskDTO::new).collect(Collectors.toList()), dayDTO.getTasks());
    }

    @Test
    public void dayDTOtoDay() {
    }
}