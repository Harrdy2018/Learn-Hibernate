package net.biancheng.www.test;

import net.biancheng.www.po.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class QueryTest {
    /**
     * hql查询数据库数据
     */
    @Test
    public void testQueryByHql() {
        String persistenceUnitName = "jpa-1";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // hql表名必须实体类名字，而且大写
        String hql = "from Customer";
        Query query = entityManager.createQuery(hql);
        List<Customer> customers = query.getResultList();
        for(Customer temp : customers) {
            System.out.println(temp);
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * sql查询数据库数据
     */
    @Test
    public void testQueryByNativeSql() {
        String persistenceUnitName = "jpa-1";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String sql = "select * from table_customer";
        Query query = entityManager.createNativeQuery(sql, Customer.class);
        List<Customer> customers = query.getResultList();
        for(Customer temp : customers) {
            System.out.println(temp);
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
