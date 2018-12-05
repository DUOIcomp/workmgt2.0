package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Manager;
import com.duoi.workmgt.dto.UserDTO;
import com.google.common.collect.Lists;

public class ManagerMapper {

    public UserDTO managerToUserDTO(Manager manager) {
        return new UserDTO(manager);
    }

    public Manager userDTOToManager(UserDTO userDTO) {
        if (userDTO == null)
            return null;
        else {
            Manager manager = new Manager();
            manager.setFirstName(userDTO.getFirstName());
            manager.setLastName(userDTO.getLastName());
            manager.setLogin(userDTO.getLogin());
            manager.setPassword(userDTO.getPassword());
            manager.setEmail(userDTO.getEmail());
            manager.setActivated(userDTO.isActivated());
            manager.setUserId(userDTO.getId());
            manager.setOrderedTasks(Lists.newArrayList());
            return manager;
        }

    }
}