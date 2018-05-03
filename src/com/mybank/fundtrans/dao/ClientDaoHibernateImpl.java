package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.Client;
import com.mybank.fundtrans.util.HibernateHelper;

import java.util.List;

public class ClientDaoHibernateImpl implements ClientDao {
    @Override
    public List findAll() {
        return new HibernateHelper().findAll("Client");
    }

    @Override
    public void insert(Client client) {
        new HibernateHelper().insert(client);
    }

    @Override
    public void delete(String IDcard) {
        new HibernateHelper().delete(Client.class, IDcard);
    }

    @Override
    public void update(Client client) {
        new HibernateHelper().update(client);
    }


    @Override
    public Client findByName(String name) {
        Object obj;
        if ((obj = new HibernateHelper().findBySomething("Client", "name", name)) != null) {
            return (Client) obj;
        }
        return null;
    }

    @Override
    public Client findByIDCard(String IDcard) {
        Object obj;
        if ((obj = new HibernateHelper().findBySomething("Client", "idcard", IDcard)) != null) {
            return (Client) obj;
        }
        return null;
    }
}
