package TestObjectFactory;

import com.duoi.workmgt.domain.*;
import com.google.common.collect.Lists;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;

public class Factory {

    public static Manager createTestManager(){
        Manager manager = new Manager();
        manager.setUserId(1L);
        manager.setEmail("manager.email@gmail.com");
        manager.setLogin("testManager");
        manager.setPassword("zaq1@WSX");
        manager.setLastName("ManagerLastName");
        manager.setFirstName("ManagerFirstName");
        manager.setActivated(true);

        return manager;
    }

    public static Employee createTestEmployee(){
        Employee employee = new Employee();
        employee.setUserId(2L);
        employee.setEmail("employee.email@gmail.com");
        employee.setLogin("testemployee");
        employee.setPassword("zaq1@WSX");
        employee.setLastName("employeeLastName");
        employee.setFirstName("employeeFirstName");
        employee.setActivated(true);
        return employee;
    }

    public static Day createTestDay(){
        Day day = new Day();
        day.setDate(LocalDate.of(2018,02,19));
        day.setDayId(1L);
        return day;
    }

    public static Company createTestCompany(){
        Company company = new Company();
        company.setCompanyName("TestCompanyName");
        company.setId(3L);
        return company;
    }

    public static Task createTestTask(){
        Task task = new Task();
        task.setTaskId(1L);
        task.setManager(createTestManager());
        task.getEmployees().add(createTestEmployee());
        task.setName("taskName");
        task.setDescription("TaskDescription");
        task.setBeginningOfTask(LocalTime.of(11,15));
        task.setEndOfTask(LocalTime.of(12,30));

        return task;
    }
}
