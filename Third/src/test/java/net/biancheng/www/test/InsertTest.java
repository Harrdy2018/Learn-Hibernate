package net.biancheng.www.test;

import net.biancheng.www.po.EmailUser;
import net.biancheng.www.po.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertTest {
    /**
     * 保存数据
     */
    @Test
    public void testInsert() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee();
        employee.setName("XiaoMing");
        employee.setBirth(new Date());
        employee.setSalary(20700.789D);
        Serializable save = session.save(employee);
        System.out.println("新增数据的主键 id:"+save);
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
