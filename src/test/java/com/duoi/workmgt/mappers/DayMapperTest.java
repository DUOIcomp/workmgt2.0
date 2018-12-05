package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.dto.DayDTO;
import com.duoi.workmgt.dto.TaskDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.stream.Collectors;

import static TestObjectFactory.Factory.createTestDay;

public class DayMapperTest {

    private DayMapper dayMapper;

    @Before
    public void setUp(){
        dayMapper = new DayMapper();
    }

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
        Day day = createTestDay();
        DayDTO dayDTO = dayMapper.dayToDayDTO(day);

        Day testDay = dayMapper.dayDTOtoDay(dayDTO);

        Assert.assertEquals(day,testDay);
    }
}