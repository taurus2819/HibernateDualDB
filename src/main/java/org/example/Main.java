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

        SessionFactory mysqlSessionFactory = HibernateUtil.buildSessionFactory("mysql.cfg.xml");
        EmployeeDao employeeDao = new EmployeeDao(mysqlSessionFactory);

        Employee emp1 = new Employee();
        emp1.setName("Agni2");
        emp1.setSalary(27000);

        Employee emp2 = new Employee();
        emp2.setName("Brahmos2");
        emp2.setSalary(18000);

        employeeDao.saveEmployee(emp1);
        employeeDao.saveEmployee(emp2);

        employeeDao.getEmployeeList("FROM Employee");

        //initialize mysql session factories
        ArrayList<SessionFactory> sessionFactoryList = new ArrayList<>();
        SessionFactory roomPostgresSessionFactory = HibernateUtil.buildSessionFactory("roompostgres.cfg.xml");
        SessionFactory roomMysqlSessionFactory = HibernateUtil.buildSessionFactory("roommysql.cfg.xml");
        sessionFactoryList.add(roomMysqlSessionFactory);
        sessionFactoryList.add(roomPostgresSessionFactory);

        //create instances of dao classes
        for(SessionFactory sessionFactory : sessionFactoryList){
            RoomDao roomDao = new RoomDao(sessionFactory);
            Room room1 = new Room();
            room1.setName("Newton2");
            room1.setBuildingId(17);
            room1.setComments("new rooms2");
            roomDao.saveRoom(room1);

            roomDao.getRoomList("FROM Room");
        }



//        RoomDao roomDao = new RoomDao(roomPostgresSessionFactory);
//        Room room1 = new Room();
//        room1.setName("Rutherford");
//        room1.setBuildingId(13);
//        room1.setComments("Renamed room");
//        roomDao.saveRoom(room1);

    }
}