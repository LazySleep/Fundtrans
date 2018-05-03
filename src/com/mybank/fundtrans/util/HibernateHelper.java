package com.mybank.fundtrans.util;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class HibernateHelper {
    public List findAll(String tableName) {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            list = session.createQuery("FROM " + tableName).list();
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

    public Object findBySomething(String tableName, String var1, Object var2) {
        Object obj = null;
        try {
            Session session = HibernateUtil.getSession();
            obj = session.createQuery(" FROM " + tableName + " WHERE " + var1 + " = ? ")
                    .setParameter(0, var2)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return obj;
    }
}
