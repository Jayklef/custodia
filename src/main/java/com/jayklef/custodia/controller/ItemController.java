package com.jayklef.custodia.controller;

import com.jayklef.custodia.dto.ItemDTO;
import com.jayklef.custodia.exception.ClientNotFoundException;
import com.jayklef.custodia.exception.ItemNotFoundException;
import com.jayklef.custodia.model.Item;
import com.jayklef.custodia.service.ClientService;
import com.jayklef.custodia.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;
    private ClientService clientService;

    @Autowired
    public ItemController(ItemService itemService, ClientService clientService) {
        this.itemService = itemService;
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public Item saveItem(@RequestBody ItemDTO itemDTO) throws ClientNotFoundException {
        log.info("Inside saveItem of ItemController");
        return itemService.saveItem(itemDTO);
    }

    @GetMapping("/getItemsList")
    public ResponseEntity<List<Item>> getItemsList(){
        log.info("Inside getItemsList of ItemController");
        List<Item> items = itemService.findItemsList();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") Long itemId) throws ItemNotFoundException {
        log.info("Inside getItemById of ItemController");
        Item item = itemService.findItemById(itemId);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/items/clients/{clientId}")
    public ResponseEntity<List<Item>> getItemByClientId(@PathVariable("clientId") Long clientId){
        log.info("Inside getItemByClientId of ItemController");
        List<Item> item = itemService.findItemByClientId(clientId);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") Long itemId,
                            @RequestBody Item item){
        Item updateItem = itemService.updateItem(itemId, item);
        log.info("Inside updateItem of ItemController");
        return new ResponseEntity<>(updateItem, HttpStatus.OK);
    }

}
