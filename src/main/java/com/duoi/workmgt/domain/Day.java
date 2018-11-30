package com.duoi.workmgt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Day {
    @Id
    @Column(name = "dayId")
    private long id;

    @DateTimeFormat
    private LocalDate date;

    @OneToMany(mappedBy = "day" , cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne(targetEntity = Company.class)
    private Company company;
}

