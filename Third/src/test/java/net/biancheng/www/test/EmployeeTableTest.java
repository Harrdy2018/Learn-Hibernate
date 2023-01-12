package net.biancheng.www.test;

import net.biancheng.www.po.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EmployeeTableTest {
    /**
     * 数据库javaguider创建表tbl_employee
     */
    @Test
    public void testCreateTable() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
        sessionFactory.close();
    }

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

    /**
     * 查询数据库数据
     */
    @Test
    public void testQuery() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, 1);
        System.out.println(employee);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /**
     * 使用 HQL 查询
     */
    @Test
    public void testHqlQuery() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Employee");
        List<Employee> resultList = query.getResultList();
        System.out.println(resultList);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
