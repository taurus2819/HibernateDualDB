package org.example.data.dao;

import org.example.data.entities.Employee;
import org.example.data.entities.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RoomDao extends Dao{

    private final SessionFactory sessionFactory;

    public RoomDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveRoom(Room room) {
        super.saveObject(room, sessionFactory);
    }

    public void getRoomList(String query) {
        List<Room> roomList = super.getObjectList(query, sessionFactory);
        for(Room room : roomList){
            System.out.printf("Room ID = %s, Room Name = %s, Building ID = %s, and Comments = %s %n", room.getRoomId(), room.getName(), room.getBuildingId(), room.getComments() );
        }
    }

    // Implement update and delete methods similarly
}
