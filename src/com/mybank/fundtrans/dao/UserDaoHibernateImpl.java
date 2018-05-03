package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.User;
import com.mybank.fundtrans.util.HibernateHelper;
import com.mybank.fundtrans.util.HibernateUtil;
import org.hibernate.Session;

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
        User user = null;
        try {
            Session session = HibernateUtil.getSession();
            user = (User) session.createQuery(" FROM User WHERE name = ? ")
                    .setParameter(0, name)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return user;
    }
}
