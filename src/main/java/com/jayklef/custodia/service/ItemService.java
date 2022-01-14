package com.jayklef.custodia.service;

import com.jayklef.custodia.dto.ItemDTO;
import com.jayklef.custodia.exception.ClientNotFoundException;
import com.jayklef.custodia.exception.ItemNotFoundException;
import com.jayklef.custodia.model.Item;

import java.util.List;

public interface ItemService {
     Item saveItem(ItemDTO itemDTO) throws ClientNotFoundException;

     List<Item> findItemsList();

     Item findItemById(Long itemId) throws ItemNotFoundException;

     List<Item> findItemByClientId(Long clientId);

     Item updateItem(Long itemId, Item item);
}
