package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Manager;
import com.duoi.workmgt.dto.UserDTO;

public class ManagerMapper {

    public UserDTO managerToUserDTO(Manager manager){
        return new UserDTO(manager);
    }

    //TODO
    public Manager userDTOToManager(UserDTO userDTO){
        return null;
    }
}
