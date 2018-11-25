package com.duoi.workmgt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menager extends User {

    @OneToMany(mappedBy = "menager")
    private List<Task> orderedTasks;
}
