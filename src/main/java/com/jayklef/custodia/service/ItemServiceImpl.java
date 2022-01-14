package com.jayklef.custodia.service;

import com.jayklef.custodia.dto.ItemDTO;
import com.jayklef.custodia.exception.ClientNotFoundException;
import com.jayklef.custodia.exception.ItemNotFoundException;
import com.jayklef.custodia.model.Category;
import com.jayklef.custodia.model.Client;
import com.jayklef.custodia.model.Item;
import com.jayklef.custodia.model.RiskLevel;
import com.jayklef.custodia.repository.CategoryRepository;
import com.jayklef.custodia.repository.ClientRepository;
import com.jayklef.custodia.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;
    private ClientRepository clientRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ClientRepository clientRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.clientRepository = clientRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Item saveItem(ItemDTO itemDTO) throws ClientNotFoundException {

            //validate earning category exist
            final Category category = this.categoryRepository
                    .getById(itemDTO.getCategoryId());

            if(category == null){
                throw new EntityNotFoundException(String.format("Category with Id: %s not found.", itemDTO.getCategoryId()));
            }

            // validate profile exist
            final Client client = this.clientRepository.getById(itemDTO.getClientId());
            if(client == null){
                throw new ClientNotFoundException(String.format("Client with Id: %s not found.", itemDTO.getClientId()));
            }

           //RiskLevel.values();

            Item item = Item.builder()
                    .itemName(itemDTO.getItemName())
                    .itemValue(itemDTO.getItemValue())
                    .category(category)
                    .client(client)
                    .build();

        //     RiskLevel.values();

            return itemRepository.save(item);
    }

    @Override
    public List<Item> findItemsList() {
        return itemRepository.findAll();
    }

    @Override
    public Item findItemById(Long itemId) throws ItemNotFoundException {
        Optional<Item> item = itemRepository.findById(itemId);

        if (itemId == null){
            throw new ItemNotFoundException("Item not found");
        }
        return itemRepository.findById(itemId).get();
    }

    @Override
    public List<Item> findItemByClientId(Long clientId) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(EntityNotFoundException::new);
        return itemRepository.findAllByClient(client);
    }

    @Override
    public Item updateItem(Long itemId, Item item) {
        Item itemInDb = itemRepository.findById(itemId).get();

        if (!Objects.nonNull(item.getItemName())&&
            !"".equalsIgnoreCase(item.getItemName())){
            itemInDb.setItemName(item.getItemName());
        }

        if (!Objects.nonNull(item.getCategory())&&
                !"".equalsIgnoreCase(item.getCategory().toString())){
            itemInDb.setCategory(item.getCategory());
        }

        if (!Objects.nonNull(item.getItemValue())&&
                !"".equalsIgnoreCase(item.getItemValue().toString())){
            itemInDb.setItemValue(item.getItemValue());
        }

        if (!Objects.nonNull(item.getClient())&&
                !"".equalsIgnoreCase(item.getClient().getClass().getName())){
            itemInDb.setClient(item.getClient());
        }

        if (!Objects.nonNull(item.getRiskLevel())&&
                !"".equalsIgnoreCase(item.getRiskLevel().getClass().getEnumConstants().toString())){
            itemInDb.setRiskLevel(item.getRiskLevel());
        }

        return itemRepository.save(itemInDb);
    }
}
