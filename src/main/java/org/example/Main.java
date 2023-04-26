package org.example;

import org.example.db.HibernateUtil;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.services.crud.ClientCrudService;
import org.example.services.crud.PlanetCrudService;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Client p = session.get(Client.class, 1L);
            Planet planet = session.get(Planet.class, Planet.Identifier.MARS);

            //Print it
            System.out.println(p); //name=John Doe, id=1
            System.out.println(planet); //name=John Doe, id=1

            // Client
            // Find and FindAll
            ClientCrudService clientCrudService = new ClientCrudService(session);
            System.out.println("clientCrudService.findAll() = " + clientCrudService.findAll());
            System.out.println("clientCrudService.find(1L) = " + clientCrudService.find(1L));

            // Insert
            Client client = new Client();
            client.setName("Test Client");
            clientCrudService.insert(client);
            System.out.println("clientCrudService.findAll() = " + clientCrudService.findAll());

            List<Client> allClients = clientCrudService.findAll();
            Long lastInsertedClientId = allClients.get(allClients.size() - 1).getId();

            // Update
            Client clientForUpdate = clientCrudService.find(lastInsertedClientId);
            System.out.println("clientForUpdate = " + clientForUpdate);
            clientForUpdate.setName("Updated Client");
            clientCrudService.update(clientForUpdate);
            System.out.println("clientCrudService.find(lastInsertedClientId) = " + clientCrudService.find(lastInsertedClientId));

            // Delete
            Client clientForDelete = clientCrudService.find(lastInsertedClientId);
            System.out.println("clientForDelete = " + clientForDelete);
            clientCrudService.delete(clientForDelete);
            System.out.println("clientCrudService.find(lastInsertedClientId) = " + clientCrudService.find(lastInsertedClientId));

            // Planet
            // Find and FindAll
            PlanetCrudService planetCrudService = new PlanetCrudService(session);
            System.out.println("planetCrudService.findAll() = " + planetCrudService.findAll());
            System.out.println("planetCrudService.find(Planet.Identifier.EARTH) = " + planetCrudService.find(Planet.Identifier.EARTH));

            // Insert
            Planet planetForInsert = new Planet();
            planetForInsert.setId(Planet.Identifier.PLUTO);
            planetForInsert.setName("Pluto");
            planetCrudService.insert(planetForInsert);
            System.out.println("planetCrudService.findAll() = " + planetCrudService.findAll());

            // Update
            Planet planetForUpdate = planetCrudService.find(Planet.Identifier.PLUTO);
            System.out.println("planetForUpdate = " + planetForUpdate);
            planetForUpdate.setName("Pluto Returned");
            planetCrudService.update(planetForUpdate);
            System.out.println("planetCrudService.find(Planet.Identifier.PLUTO) = " + planetCrudService.find(Planet.Identifier.PLUTO));

            // Delete
            Planet planetForDelete = planetCrudService.find(Planet.Identifier.PLUTO);
            System.out.println("planetForDelete = " + planetForDelete);
            planetCrudService.delete(planetForDelete);
            System.out.println("planetCrudService.find(Planet.Identifier.PLUTO) = " + planetCrudService.find(Planet.Identifier.PLUTO));
        }
    }
}