package net.biancheng.www.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class PersonTableTest {
    /**
     * 数据库javaguider创建表tbl_person
     */
    @Test
    public void testCreateTable() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
        sessionFactory.close();
    }
}
