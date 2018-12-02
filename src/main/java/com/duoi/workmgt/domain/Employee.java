package com.duoi.workmgt.domain;


import com.google.common.collect.Lists;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee extends User {

    @ManyToMany(targetEntity = Task.class)
    private List<Task> tasks = Lists.newArrayList();

}
