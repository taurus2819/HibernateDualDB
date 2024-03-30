package org.example.data.dao;

import org.example.data.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class EmployeeDao {
    private SessionFactory sessionFactory;

    public EmployeeDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    // Implement update and delete methods similarly
}
