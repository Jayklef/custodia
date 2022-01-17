package com.jayklef.custodia.repository;

import com.jayklef.custodia.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

     @Query(value = "SELECT q From Item q where q.client = :clientId")
     List<Item> findAllByClientId(@Param("clientId") Long clientId);

}
