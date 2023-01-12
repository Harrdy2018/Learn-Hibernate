package net.biancheng.www.test;

import net.biancheng.www.po.EmailUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmailUserTableTest {
    /**
     * 使用 HQL 查询
     */
    @Test
    public void testHqlQueryEmailUser() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from EmailUser");
        List<EmailUser> resultList = query.getResultList();
        System.out.println(resultList);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testInsertEmailUser() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        EmailUser emailUser = new EmailUser();
        emailUser.setName("oppo");
        List<String> emailList = new ArrayList<String>();
        emailList.add("123@qq.com");
        emailList.add("456@qq.com");
        emailList.add("789@qq.com");
        emailUser.setEmailList(emailList);
        Serializable save = session.save(emailUser);
        System.out.println("新增数据的主键 id:"+save);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
