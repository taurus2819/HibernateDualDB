package org.example.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory(String configFile) {
        //load hibernate configuration from XML file
        System.out.println("Using config file = " + configFile);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                                                        .configure(configFile).build();
        try{
            //create sessionFactory from the hibernate configuration
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch(Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
            throw new RuntimeException("Error building sessionfactory");
        }
    }

}
