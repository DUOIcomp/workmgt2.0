package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Day;
import org.junit.Test;

import static TestObjectFactory.Factory.createTestDay;
import static org.junit.Assert.*;

public class DayMapperTest {

    @Test
    public void dayToDayDTO() {
        Day day = createTestDay();
        System.out.println(day.toString());

        DayMapper dayMapper = new DayMapper();
        System.out.println(dayMapper.dayToDayDTO(day));
    }

    @Test
    public void dayDTOtoDay() {
    }
}