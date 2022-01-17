package com.jayklef.custodia.service;

import com.jayklef.custodia.dto.ItemDTO;
import com.jayklef.custodia.exception.ClientNotFoundException;
import com.jayklef.custodia.exception.ItemNotFoundException;
import com.jayklef.custodia.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public interface ItemService {
     Item saveItem(ItemDTO itemDTO) throws ClientNotFoundException;

     List<Item> findItemsList();

     Item findItemById(Long itemId) throws ItemNotFoundException;

     List<Item> findAllItemsByClientId(Long clientId) throws ClientNotFoundException;

     Item updateItem(Long itemId, Item item);

}
