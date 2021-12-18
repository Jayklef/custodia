package com.jayklef.custodia.service;

import com.jayklef.custodia.dto.ItemDTO;
import com.jayklef.custodia.exception.ClientNotFoundException;
import com.jayklef.custodia.model.Item;

import java.util.List;

public interface ItemService {
     Item saveItem(ItemDTO itemDTO) throws ClientNotFoundException;

     List<Item> getItemsList();

     Item getItemById(Long itemId);

     List<Item> getItemsByClientId(Long clientId);

     Item updateItem(Long itemId, Item item);
}
