package org.example.services.crud;

import lombok.RequiredArgsConstructor;
import org.example.entity.Client;
import org.hibernate.Session;

import java.util.List;

@RequiredArgsConstructor
public class ClientCrudService {
    private final Session session;

    public void insert(Client client) {

    }

    public void update(Client client) {

    }

    public Client find(Long id) {

    }

    public List<Client> findAll() {

    }
}
