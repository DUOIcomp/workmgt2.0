package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Manager;
import com.duoi.workmgt.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;

import static TestObjectFactory.Factory.createTestManager;
import static org.junit.Assert.*;

public class ManagerMapperTest {

    private ManagerMapper managerMapper = new ManagerMapper();

    @Test
    public void managerToUserDTO() {
        Manager manager = createTestManager();

        UserDTO managerDTO = managerMapper.managerToUserDTO(manager);

        Assert.assertEquals(manager.getUserId(),managerDTO.getId());
        Assert.assertEquals(manager.getEmail(),managerDTO.getEmail());
        Assert.assertEquals(manager.getLogin(),managerDTO.getLogin());
        Assert.assertEquals(manager.getFirstName(),managerDTO.getFirstName());
        Assert.assertEquals(manager.getLastName(),managerDTO.getLastName());
        Assert.assertEquals(manager.getPassword(),managerDTO.getPassword());
    }

    @Test
    public void userDTOToManager() {
        Manager manager = createTestManager();
        UserDTO userDTO = managerMapper.managerToUserDTO(manager);

        Manager testManager = managerMapper.userDTOToManager(userDTO);

        Assert.assertEquals(manager,testManager);
    }
}