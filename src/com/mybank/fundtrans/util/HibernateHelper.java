package com.mybank.fundtrans.util;

import com.mybank.fundtrans.domain.Fund;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class HibernateHelper {
    public List findAll(String tableName) {
        List list = null;
        try {
            String hql = "FROM " + tableName;
            Session session = HibernateUtil.getSession();
            list = session.createQuery(hql).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return list;
    }

    public void insert(Object obj) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void delete(Class _class, Serializable var) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(_class, var));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void update(Object obj) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(obj);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Fund findById(int fundNo) {
        return null;
    }
}
