package org.example.db;

import lombok.Getter;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Closeable;

public class HibernateUtil implements Closeable {
    private static final HibernateUtil INSTANCE;

    @Getter
    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}