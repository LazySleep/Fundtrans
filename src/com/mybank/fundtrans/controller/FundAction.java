package com.mybank.fundtrans.controller;

import com.mybank.fundtrans.dao.FundDao;
import com.mybank.fundtrans.dao.FundDaoHibernateImpl;
import com.mybank.fundtrans.domain.Fund;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

public class FundAction extends ActionSupport {

    private int id;
    private Fund fund;
    private FundDao fundDao = new FundDaoHibernateImpl();
    private List<Fund> funds;

    /**
     * 新增数据
     *
     * @return
     */
    public String add() {
        fundDao.insert(fund);
        return "success";
    }

    /**
     * 根据id删除数据
     *
     * @return
     */
    public String delete() {
        fundDao.delete(id);
        return "success";
    }

    /**
     * 更新数据由fund
     *
     * @return
     */
    public String update() {
        fundDao.update(fund);
        return "success";
    }

    /**
     * 传入id转至update
     *
     * @return
     */
    public String startUpdate() {
        fund = fundDao.findById(id);
        return "startUpdate";
    }

    /**
     * 获取fund表所有数据
     *
     * @return
     */
    public String show() {
        funds = fundDao.findAll();
        ((Map) ActionContext.getContext().get("request")).put("fundList", funds);
        return "showFunds";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public FundDao getFundDao() {
        return fundDao;
    }

    public void setFundDao(FundDao fundDao) {
        this.fundDao = fundDao;
    }

    public List<Fund> getFunds() {
        return funds;
    }

    public void setFunds(List<Fund> funds) {
        this.funds = funds;
    }
}
