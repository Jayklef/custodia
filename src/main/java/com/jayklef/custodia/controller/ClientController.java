package com.jayklef.custodia.controller;

import com.jayklef.custodia.model.Client;
import com.jayklef.custodia.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/saveClientWithNextOfKin")
    public Client saveClientWithNextOfKin(@Valid @RequestBody Client client){
        log.info("Inside saveClientWithNextOfKin of ClientControlller");
        return clientService.saveClientWithNextOfKin(client);
    }

    @GetMapping("/clients")
    public List<Client> clients(){
        log.info("Inside clients of ClientControlller");
        return clientService.clients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable ("id") Long clientId){
        log.info("Inside getClientById of ClientControlller");
        return clientService.getClientById(clientId);
    }

    @GetMapping("/{name}")
    public Client getClientByClientName(@PathVariable("name") String clientName){
        log.info("Inside getClientByClientName of ClientControlller");
        return clientService.getClientByClientName(clientName);
    }

    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable("id") Long clientId,
                                @RequestBody Client client){
        log.info("Inside updateClient of ClientControlller");
        return clientService.updateClient(clientId, client);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClientById(@PathVariable("id") Long clientId){
        log.info("Inside deleteClientById of ClientControlller");
        clientService.deleteClientById(clientId);
        return "Client deleted successully";
    }

}
