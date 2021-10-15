package com.jayklef.custodia.service;

import com.jayklef.custodia.dto.ItemDTO;
import com.jayklef.custodia.error.ClientNotFoundException;
import com.jayklef.custodia.model.Item;

import java.util.List;

public interface ItemService {
    public Item saveItem(ItemDTO itemDTO) throws ClientNotFoundException;

    public List<Item> getItemsList();

    public Item getItemById(Long itemId);

    public List<Item> getItemsByClientId(Long clientId);

    public Item updateItem(Long itemId, Item item);
}
