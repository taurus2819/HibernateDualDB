package org.example.data.dao;

import org.example.data.entities.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RoomDao {

    private SessionFactory sessionFactory;

    public RoomDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveRoom(Room room) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(room);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Room getRoomById(int id) {
        Session session = sessionFactory.openSession();
        Room room = session.get(Room.class, id);
        session.close();
        return room;
    }

    // Implement update and delete methods similarly
}
