package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.HibernateHelper;

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
        Object obj;
        if((obj=new HibernateHelper().findBySomething("Fund","id",fundNo))!=null){
            return (Fund)obj;
        }
        return null;
    }
}
