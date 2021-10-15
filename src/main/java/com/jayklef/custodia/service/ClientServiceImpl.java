package com.jayklef.custodia.service;

import com.jayklef.custodia.model.Client;
import com.jayklef.custodia.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClientWithNextOfKin(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> clients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).get();
    }

    @Override
    public Client getClientByClientName(String clientName) {
        return clientRepository.findClientByClientName(clientName);
    }

    @Override
    public Client updateClient(Long clientId, Client client) {
       Client clientInDb = clientRepository.findById(clientId).get();

       if (Objects.nonNull(client.getClientName())&&
       !"".equalsIgnoreCase(client.getClientName())){
           clientInDb.setClientName(client.getClientName());
       }

        if (Objects.nonNull(client.getGender())&&
                !"".equalsIgnoreCase(client.getGender())){
            clientInDb.setGender(client.getGender());
        }

        if (Objects.nonNull(client.getClientEmail())&&
                !"".equalsIgnoreCase(client.getClientEmail())){
            clientInDb.setClientEmail(client.getClientEmail());
        }
        if (Objects.nonNull(client.getClientAddress())&&
                !"".equalsIgnoreCase(client.getClientAddress())){
            clientInDb.setClientAddress(client.getClientAddress());
        }

        if (Objects.nonNull(client.getBirthDate())){
            clientInDb.setBirthDate(client.getBirthDate());
        }

        if (Objects.nonNull(client.getClientMobile())&&
                !"".equalsIgnoreCase(client.getClientMobile())){
            clientInDb.setClientMobile(client.getClientMobile());
        }

        return clientRepository.save(clientInDb);
    }

    @Override
    public void deleteClientById(Long clientId) {
        clientRepository.getById(clientId);
    }

}
