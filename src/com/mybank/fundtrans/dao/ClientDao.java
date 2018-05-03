package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.Client;

import java.util.List;

public interface ClientDao {
    List findAll();

    void insert(Client client);

    void delete(String IDcard);

    void update(Client client);

    Client findByName(String name);

    Client findByIDCard(String IDcard);
}
