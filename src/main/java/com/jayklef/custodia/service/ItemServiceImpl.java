package com.jayklef.custodia.service;

import com.jayklef.custodia.model.Client;
import com.jayklef.custodia.model.Item;
import com.jayklef.custodia.repository.ClientRepository;
import com.jayklef.custodia.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;
    private ClientRepository clientRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ClientRepository clientRepository) {
        this.itemRepository = itemRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItemsList() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId).get();
    }

    @Override
    public List<Item> getItemsByClientId(Long clientId) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(EntityNotFoundException::new);
        return itemRepository.findAllByClient(client);
    }

    @Override
    public Item updateItem(Long itemId, Item item) {
        Item itemInDb = itemRepository.findById(itemId).get();

        if (!item.getItemName().isBlank()){
            itemInDb.setItemName(item.getItemName());
            itemInDb.setCategory(item.getCategory());
            itemInDb.setClient(item.getClient());


            itemInDb.setItemValue(item.getItemValue());
        }

       /* if (Objects.nonNull(item.getItemValue())){
            itemInDb.setItemValue(item.getItemValue());
        }*/

        return itemRepository.save(itemInDb);
    }
}
