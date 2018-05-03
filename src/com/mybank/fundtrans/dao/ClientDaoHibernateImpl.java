package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.Client;
import com.mybank.fundtrans.util.HibernateHelper;
import com.mybank.fundtrans.util.HibernateUtil;
import org.hibernate.Session;

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
        Client client = null;
        try {
            Session session = HibernateUtil.getSession();
            client = (Client) session.createQuery(" FROM Client WHERE name = ? ")
                    .setParameter(0, name)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return client;
    }

    @Override
    public Client findByIDCard(String IDcard) {
        Client client = null;
        try {
            Session session = HibernateUtil.getSession();
            client = (Client) session.createQuery(" FROM Client WHERE idcard = ? ")
                    .setParameter(0, IDcard)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return client;
    }
}
