package com.mybank.fundtrans.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static SessionFactory sessionFactory = null; // SessionFactory对象

    // 静态块
    static {
        buildSessionFactory();
    }

    /**
     * 获取Session
     *
     * @return Session
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                buildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            threadLocal.set(session);
        }
        return session;
    }

    /**
     * 建造会话工厂
     */
    private static void buildSessionFactory() {
        try {
            Configuration cfg = new Configuration().configure(); // 加载Hibernate配置文件
            sessionFactory = cfg
                    .buildSessionFactory(new ServiceRegistryBuilder().applySettings(cfg.getProperties())
                            .buildServiceRegistry());
        } catch (Exception e) {
            System.err.println("创建会话工厂失败");
            e.printStackTrace();
        }
    }

    /**
     * 获取SessionFactory对象
     *
     * @return SessionFactory对象
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * 关闭Session
     *
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close(); // 关闭Session
        }
    }
}
