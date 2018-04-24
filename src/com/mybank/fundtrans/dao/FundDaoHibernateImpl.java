package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FundDaoHibernateImpl implements FundDao {
    @Override
    public List findAll() {
        List funds = null;
        try {
            String hql = "FROM Fund";
            Session session = HibernateUtil.getSession();
            funds = session.createQuery(hql).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return funds;
    }

    @Override
    public void insert(Fund fund) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(fund);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public void delete(int fundNo) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Fund.class, fundNo));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public void update(Fund fund) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(fund);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public Fund findById(int fundNo) {
        Fund fund = null;
        try {
            Session session = HibernateUtil.getSession();
            fund = (Fund) session.createQuery(" FROM Fund WHERE id = ? ")
                    .setParameter(0, fundNo)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return fund;
    }
}
