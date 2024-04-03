package org.example.data.dao;

import org.example.data.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class EmployeeDao extends Dao{
    private final SessionFactory sessionFactory;

    public EmployeeDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveEmployee(Employee employee) {
        super.saveObject(employee, sessionFactory);
    }

    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    // Implement update and delete methods similarly
}
