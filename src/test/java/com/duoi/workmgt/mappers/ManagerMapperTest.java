package com.duoi.workmgt.mappers;

import com.duoi.workmgt.domain.Manager;
import org.junit.Test;

import static TestObjectFactory.Factory.createTestManager;
import static org.junit.Assert.*;

public class ManagerMapperTest {

    @Test
    public void managerToUserDTO() {
        Manager manager = createTestManager();

        System.out.println(manager);

        ManagerMapper managerMapper = new ManagerMapper();

        System.out.println(managerMapper.managerToUserDTO(manager));
    }

    @Test
    public void userDTOToManager() {
    }
}