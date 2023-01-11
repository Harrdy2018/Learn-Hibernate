package net.biancheng.www.test;

import net.biancheng.www.po.EmailUser;
import net.biancheng.www.po.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class QueryTest {
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
        System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getBirth()+" "+employee.getSalary());
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
        for (Employee employee : resultList) {
            System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getBirth()+" "+employee.getSalary());
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

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
}
