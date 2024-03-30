package org.example;

import org.example.data.HibernateUtil;
import org.example.data.dao.EmployeeDao;
import org.example.data.dao.RoomDao;
import org.example.data.entities.Employee;
import org.example.data.entities.Room;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //initialize mysql session factories
        ArrayList<SessionFactory> sessionFactoryList = new ArrayList<SessionFactory>();
        SessionFactory mysqlSessionFactory = HibernateUtil.buildSessionFactory("mysql.cfg.xml");
        EmployeeDao employeeDao = new EmployeeDao(mysqlSessionFactory);

        Employee emp1 = new Employee();
        emp1.setName("C130 Hercules");
        emp1.setSalary(4000);

        Employee emp2 = new Employee();
        emp2.setName("B52");
        emp2.setSalary(5000);

        employeeDao.saveEmployee(emp1);
        employeeDao.saveEmployee(emp2);

        SessionFactory postgresSessionFactory = HibernateUtil.buildSessionFactory("postgres.cfg.xml");
//        sessionFactoryList.add(mysqlSessionFactory);
//        sessionFactoryList.add(postgresSessionFactory);

        //create instances of dao classes
//        for(SessionFactory sessionFactory : sessionFactoryList){
//            EmployeeDao employeeDao = new EmployeeDao(sessionFactory);
//
//            Employee emp1 = new Employee();
//            emp1.setName("Nag");
//            emp1.setSalary(9000);
//
//            Employee emp2 = new Employee();
//            emp2.setName("Bhramha");
//            emp2.setSalary(10000);
//
//            employeeDao.saveEmployee(emp1);
//            employeeDao.saveEmployee(emp2);
//        }

        RoomDao roomDao = new RoomDao(postgresSessionFactory);
        Room room1 = new Room();
        room1.setName("NIC");
        room1.setBuildingId(14);
        room1.setComments("New rooms");
        roomDao.saveRoom(room1);

    }
}