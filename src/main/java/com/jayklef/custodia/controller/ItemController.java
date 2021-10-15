package com.jayklef.custodia.controller;

import com.jayklef.custodia.model.Item;
import com.jayklef.custodia.service.ClientService;
import com.jayklef.custodia.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private ItemService itemService;
    private ClientService clientService;

    @Autowired
    public ItemController(ItemService itemService, ClientService clientService) {
        this.itemService = itemService;
        this.clientService = clientService;
    }

    @PostMapping("/items")
    public Item saveItem(@RequestBody Item item){
        return itemService.saveItem(item);
    }

    @GetMapping("/items")
    public List<Item> getItemsList(){
        return itemService.getItemsList();
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable("id") Long itemId){
        return itemService.getItemById(itemId);
    }

    @GetMapping("/items/clients/{clientId}")
    public ResponseEntity<List<Item>> getItemByClientName(@PathVariable("clientId") Long clientId){
        return ResponseEntity.ok().body(itemService.getItemsByClientId(clientId));
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable("id") Long itemId,
                            @RequestBody Item item){
        return itemService.updateItem(itemId, item);
    }

}
