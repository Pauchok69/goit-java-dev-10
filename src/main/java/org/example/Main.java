package org.example;

import org.example.db.HibernateUtil;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.services.crud.ClientCrudService;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Client p = session.get(Client.class, 1L);
            Planet planet = session.get(Planet.class, Planet.Identifier.MARS);

            //Print it
            System.out.println(p); //name=John Doe, id=1
            System.out.println(planet); //name=John Doe, id=1

            // Find and FindAll
            ClientCrudService clientCrudService = new ClientCrudService(session);
            System.out.println("clientCrudService.findAll() = " + clientCrudService.findAll());
            System.out.println("clientCrudService.find(1L) = " + clientCrudService.find(1L));

            // Insert
            Client client = new Client();
            client.setName("Test Client");
            clientCrudService.insert(client);
            System.out.println("clientCrudService.findAll() = " + clientCrudService.findAll());

            // Update
            Client clientForUpdate = clientCrudService.find(6L);
            System.out.println("clientForUpdate = " + clientForUpdate);
            clientForUpdate.setName("Updated Client");
            clientCrudService.update(clientForUpdate);
            System.out.println("clientCrudService.find(6L) = " + clientCrudService.find(6L));

            // Delete
            Client clientForDelete = clientCrudService.find(6L);
            System.out.println("clientForDelete = " + clientForDelete);
            clientCrudService.delete(clientForDelete);
            System.out.println("clientCrudService.find(6L) = " + clientCrudService.find(6L));
        }
    }
}