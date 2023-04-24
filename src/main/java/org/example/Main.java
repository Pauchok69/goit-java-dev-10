package org.example;

import org.example.db.HibernateUtil;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Client p = session.get(Client.class, 1L);
            Planet planet = session.get(Planet.class, Planet.Identifier.MARS);

            //Print it
            System.out.println(p); //name=John Doe, id=1
            System.out.println(planet); //name=John Doe, id=1
        }
    }
}