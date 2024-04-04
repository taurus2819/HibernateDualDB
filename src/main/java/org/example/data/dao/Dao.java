package org.example.data.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public abstract class Dao {
    public <T> void saveObject(T object, SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(object);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public <T> List<T> getObjectList(String query,SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List<T> list = (List<T>) session.createQuery(query).list();
            tx.commit();
            return list;
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
