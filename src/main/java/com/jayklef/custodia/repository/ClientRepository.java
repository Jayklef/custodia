package com.jayklef.custodia.repository;

import com.jayklef.custodia.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findClientByClientName(String name);
}
