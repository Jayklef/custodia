package com.jayklef.custodia.service;

import com.jayklef.custodia.model.Client;

import java.util.List;

public interface ClientService {
     Client saveClientWithNextOfKin(Client client);

     List<Client> clients();

     Client getClientById(Long clientId);

     Client getClientByClientName(String clientName);

     Client updateClient(Long clientId, Client client);

     void deleteClientById(Long clientId);
}
