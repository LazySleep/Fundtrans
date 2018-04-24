package com.mybank.fundtrans.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fund")
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String description;
    private String status;
    private Date createTime;

    public Fund() {
        super();
        createTime = new Date();
    }

    public Fund(Integer id, String name, double price, String description, String status, Date createTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

//    public String toTrTdTag() {
//        return "<tr><td>" + id + "</td><td>" + name + "</td><td>" + price + "</td><td>"
//                + description + "</td><td>" + status + "</td><td>" + createTime + "</td></tr>";
//    }
}
