package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.User;

import java.util.List;

public interface UserDao {
    List findAll();
    void insert(User user);
    void delete(String name);
    void update(User user);
    User findByName(String name);
}
