package org.example.services.crud;

import lombok.RequiredArgsConstructor;
import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@RequiredArgsConstructor
public class ClientCrudService implements CrudService<Long, Client> {
    private final Session session;

    public void insert(Client client) {
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
    }

    public void update(Client client) {
        insert(client);
    }

    public Client find(Long id) {
        return session.get(Client.class, id);
    }

    public List<Client> findAll() {
        return session.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public void delete(Client client) {
        Transaction transaction = session.beginTransaction();
        session.remove(client);
        transaction.commit();
    }
}
