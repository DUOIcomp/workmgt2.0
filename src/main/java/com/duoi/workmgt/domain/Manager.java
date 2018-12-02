package com.duoi.workmgt.domain;

import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Manager extends User {

    @OneToMany(mappedBy = "manager")
    private List<Task> orderedTasks = Lists.newArrayList();
}
