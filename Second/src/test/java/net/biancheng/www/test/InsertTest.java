package net.biancheng.www.test;

import net.biancheng.www.po.Customer;
import net.biancheng.www.po.Student;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class InsertTest {
    /**
     * 插入数据
     */
    @Test
    public void testInsert() {
        String persistenceUnitName = "jpa-1";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setAge(13);
        customer.setEmail("tissdwssh@qq.com");
        customer.setLastName("Gim");
        customer.setBirth(new Date());
        customer.setCreatedTime(new Date());
        entityManager.persist(customer);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * student 插入数据验证主键生成策略
     */
    @Test
    public void testInsertStu() {
        String persistenceUnitName = "jpa-1";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Student student = new Student();
        student.setName("XiaoMing");
        entityManager.persist(student);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
