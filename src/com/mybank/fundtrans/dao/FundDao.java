package com.mybank.fundtrans.dao;
import java.util.List;
import com.mybank.fundtrans.domain.Fund;
/**
* Description: TODO
* @author 
* @date 2017年2月25日 下午2:57:56
 */
public interface FundDao {
	List findAll();    //获取所有的基金记录,返回Fund对象列表
	void insert(Fund fund);    //插入一条基金记录
	void delete(int fundNo);    //按主键删除一条基金记录
	void update(Fund fund);    //更新一条基金记录
	Fund findById(int fundNo);  //按主键查找基金记录，返回Fund对象
}
