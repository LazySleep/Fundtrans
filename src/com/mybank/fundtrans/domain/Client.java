package com.mybank.fundtrans.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GenericGenerator(name = "assigned", strategy = "assigned")
    @GeneratedValue(generator = "assigned")
    private String IDCard;   //身份证号
    @Column(name = "name", nullable = false)
    private String name;   //姓名
    private String sex;   //性别
    private String phone;  //电话
    private String address;  //地址
    private String email;   //邮箱
    private String hobby;  //兴趣爱好
    private Date createTime;  //创建日期

    public Client() {
        super();
        createTime = new Date();
    }

    public Client(String IDCard, String name, String sex, String phone, String address, String email, String hobby, Date createTime) {
        this.IDCard = IDCard;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.hobby = hobby;
        this.createTime = createTime;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String iDCard) {
        IDCard = iDCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date creatTime) {
        this.createTime = creatTime;
    }


}
