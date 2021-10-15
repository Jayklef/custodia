package com.jayklef.custodia.repository;

import com.jayklef.custodia.model.Client;
import com.jayklef.custodia.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


    public List<Item> findAllByClient(Client  client);
}
