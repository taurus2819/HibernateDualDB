package org.example.data.dao;

import org.example.data.entities.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RoomDao extends Dao{

    private final SessionFactory sessionFactory;

    public RoomDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveRoom(Room room) {
        super.saveObject(room, sessionFactory);
    }

    public Room getRoomById(int id) {
        Session session = sessionFactory.openSession();
        Room room = session.get(Room.class, id);
        session.close();
        return room;
    }

    // Implement update and delete methods similarly
}
