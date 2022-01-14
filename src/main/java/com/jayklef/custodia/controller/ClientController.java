package com.jayklef.custodia.controller;

import com.jayklef.custodia.model.Client;
import com.jayklef.custodia.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Client> saveClientWithNextOfKin(@Valid @RequestBody Client client){
        log.info("Inside saveClientWithNextOfKin of ClientController");
        Client newClient = clientService.saveClientWithNextOfKin(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @GetMapping("/clientLists")
    public ResponseEntity<List<Client>> clientLists(){
        log.info("Inside clients of ClientController");
        List<Client> clientList = clientService.findAllClients();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable ("id") Long clientId){
        log.info("Inside getClientById of ClientController");
        Client client = clientService.findClientById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Client> getClientByClientName(@PathVariable("name") String clientName){
        log.info("Inside getClientByClientName of ClientController");
        Client client = clientService.findClientByName(clientName);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long clientId,
                                @RequestBody Client client){
        log.info("Inside updateClient of ClientController");
        Client updateClient = clientService.updateClient(clientId, client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable("id") Long clientId){
        log.info("Inside deleteClientById of ClientController");
        clientService.deleteClientById(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
