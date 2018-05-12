package com.mybank.fundtrans.controller;


import com.mybank.fundtrans.dao.ClientDao;
import com.mybank.fundtrans.dao.ClientDaoHibernateImpl;
import com.mybank.fundtrans.domain.Client;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

public class ClientAction extends ActionSupport {
    private String idCard;
    private Client client;
    private ClientDao clientDao = new ClientDaoHibernateImpl();
    private List<Client> clients;

    /**
     * 新增数据
     *
     * @return
     */
    public String add() {
        clientDao.insert(client);
        return "success";
    }

    /**
     * 根据idcard删除数据
     *
     * @return
     */
    public String delete() {
        clientDao.delete(idCard);
        return "success";
    }

    /**
     * 更新数据由client
     *
     * @return
     */
    public String update() {
        clientDao.update(client);
        return "success";
    }

    /**
     * 传入idcard转至update
     *
     * @return
     */
    public String startUpdate() {
        client = clientDao.findByIDCard(idCard);
        return "startUpdate";
    }

    /**
     * 获取client表所有数据
     *
     * @return
     */
    public String show() {
        clients = clientDao.findAll();
        ((Map) ActionContext.getContext().get("request")).put("clients", clients);
        return "showClients";
    }



    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
