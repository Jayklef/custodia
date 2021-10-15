package com.jayklef.custodia.service;

import com.jayklef.custodia.model.Client;

import java.util.List;

public interface ClientService {
    public Client saveClientWithNextOfKin(Client client);

    public List<Client> clients();

    public Client getClientById(Long clientId);

    public Client getClientByClientName(String clientName);

    public Client updateClient(Long clientId, Client client);

    public void deleteClientById(Long clientId);
}
