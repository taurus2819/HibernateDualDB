package org.example.data.dao;

import org.example.data.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployeeDao extends Dao{
    private final SessionFactory sessionFactory;

    public EmployeeDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveEmployee(Employee employee) {
        super.saveObject(employee, sessionFactory);
    }

    public void getEmployeeList(String query) {
        List<Employee> employeeList = super.getObjectList(query, sessionFactory);
        for(Employee employee : employeeList){
            System.out.printf("Employee ID = %s, Employee Name = %s, and Salary = %s %n", employee.getId(), employee.getName(), employee.getSalary() );
        }
    }

    // Implement update and delete methods similarly
}
