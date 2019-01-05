package lk.ijse.gdse.computerParts.resources;

import lk.ijse.gdse.computerParts.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;

public class HibernetUtil {
    private static SessionFactory sessionFactory= buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().loadProperties("application.properties").build();
        Metadata metadata=new MetadataSources(registry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Reception.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(OrderDetails.class)
                .addAnnotatedClass(UserSeting.class)
                .buildMetadata();

        return metadata.getSessionFactoryBuilder().build();

    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
