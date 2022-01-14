package com.jayklef.custodia.service;

import com.jayklef.custodia.model.Client;

import java.util.List;

public interface ClientService {
     Client saveClientWithNextOfKin(Client client);

     List<Client> findAllClients();

     Client findClientById(Long clientId);

     Client findClientByName(String clientName);

     Client updateClient(Long clientId, Client client);

     void deleteClientById(Long clientId);
}
