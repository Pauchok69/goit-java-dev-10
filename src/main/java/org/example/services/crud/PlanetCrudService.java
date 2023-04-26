package org.example.services.crud;

import lombok.RequiredArgsConstructor;
import org.example.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@RequiredArgsConstructor
public class PlanetCrudService implements CrudService<Planet.Identifier, Planet> {
    private final Session session;

    public void insert(Planet planet) {
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
    }

    public void update(Planet planet) {
        insert(planet);
    }

    public Planet find(Planet.Identifier id) {
        return session.get(Planet.class, id);
    }

    public List<Planet> findAll() {
        return session.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
    }

    public void delete(Planet planet) {
        Transaction transaction = session.beginTransaction();
        session.remove(planet);
        transaction.commit();
    }
}
