package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.HibernateHelper;
import com.mybank.fundtrans.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class FundDaoHibernateImpl implements FundDao {
    @Override
    public List findAll() {
        return new HibernateHelper().findAll("Fund");
    }

    @Override
    public void insert(Fund fund) {
        new HibernateHelper().insert(fund);
    }

    @Override
    public void delete(int fundNo) {
        new HibernateHelper().delete(Fund.class, fundNo);
    }

    @Override
    public void update(Fund fund) {
        new HibernateHelper().update(fund);
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
