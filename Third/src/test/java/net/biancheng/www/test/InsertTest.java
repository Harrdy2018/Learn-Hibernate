package net.biancheng.www.test;

import net.biancheng.www.po.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;

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
}
