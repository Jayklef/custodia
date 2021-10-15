package com.jayklef.custodia.service;

import com.jayklef.custodia.model.Item;

import java.util.List;

public interface ItemService {
    public Item saveItem(Item item);

    public List<Item> getItemsList();

    public Item getItemById(Long itemId);

    public List<Item> getItemsByClientId(Long clientId);

    public Item updateItem(Long itemId, Item item);
}
