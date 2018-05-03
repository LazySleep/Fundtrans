package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.User;
import com.mybank.fundtrans.util.HibernateHelper;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    @Override
    public List findAll() {
        return new HibernateHelper().findAll("User");
    }

    @Override
    public void insert(User user) {
        new HibernateHelper().insert(user);
    }

    @Override
    public void delete(String name) {
        new HibernateHelper().delete(User.class, name);
    }

    @Override
    public void update(User user) {
        new HibernateHelper().update(user);
    }

    @Override
    public User findByName(String name) {
        Object obj;
        if ((obj = new HibernateHelper().findBySomething("User", "name", name)) != null) {
            return (User) obj;
        }
        return null;
    }
}
