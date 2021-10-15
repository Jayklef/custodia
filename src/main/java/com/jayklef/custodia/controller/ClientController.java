package com.jayklef.custodia.controller;

import com.jayklef.custodia.model.Client;
import com.jayklef.custodia.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public Client saveClientWithNextOfKin(@Valid @RequestBody Client client){
        return clientService.saveClientWithNextOfKin(client);
    }

    @GetMapping("/clients")
    public List<Client> clients(){
        return clientService.clients();
    }

    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable ("id") Long clientId){
        return clientService.getClientById(clientId);
    }

    @GetMapping("/clients/name/{name}")
    public Client getClientByClientName(@PathVariable("name") String clientName){
        return clientService.getClientByClientName(clientName);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable("id") Long clientId,
                                @RequestBody Client client){
        return clientService.updateClient(clientId, client);
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClientById(@PathVariable("id") Long clientId){
        clientService.deleteClientById(clientId);
        return "Client deleted successully";
    }

}
