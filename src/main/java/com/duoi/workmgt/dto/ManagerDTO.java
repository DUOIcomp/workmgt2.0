package com.duoi.workmgt.dto;

import com.duoi.workmgt.domain.Manager;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class ManagerDTO extends UserDTO{

    private List<TaskDTO> orderedTask;

    ManagerDTO(){}

    public ManagerDTO(Manager manager) {
        super(manager);
        this.orderedTask = manager.getOrderedTasks().stream()
                        .map(task -> new TaskDTO(task))
                        .collect(Collectors.toList());
    }


}
