package com.duoi.workmgt.domain;

import com.google.common.collect.Lists;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Day {
    @Id
    @GeneratedValue
    private Long dayId;

    private LocalDate date;

    @OneToMany(mappedBy = "day" , cascade = CascadeType.ALL)
    private List<Task> tasks = Lists.newArrayList();


    public Day() {
    }

    public Day(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayId=" + dayId +
                ", date=" + date +
                ", tasks=" + tasks +
                '}';
    }
}

