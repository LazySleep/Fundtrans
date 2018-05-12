package com.mybank.fundtrans.controller;

import com.mybank.fundtrans.dao.UserDao;
import com.mybank.fundtrans.dao.UserDaoHibernateImpl;
import com.mybank.fundtrans.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

public class UserAction extends ActionSupport {

    private String name;
    private User user;
    private UserDao userDao = new UserDaoHibernateImpl();
    private List<User> users;

    public String check() {
        User u;
        if (user.getPassword().isEmpty()) {
            return "failed";
        } else if ((u = userDao.findByName(user.getName())) != null) {
            if (user.getPassword().equals(u.getPassword())) {
                //获取session对象
                Map session = ActionContext.getContext().getSession();
                session.put("user", user);
                return "success";
            }
        }
        return "failed";
    }

    public String outLogin(){
        Map session = ActionContext.getContext().getSession();
        session.remove("user");
        return "failed";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
