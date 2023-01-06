package net.biancheng.www.test;

import net.biancheng.www.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class QueryTest {
    /**
     * 查询数据库数据
     */
    @Test
    public void testQuery() {
        //Hibernate 加载核心配置文件（有数据库连接信息）
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //根据主键查询 user 表中的记录
        User user = session.get(User.class, 1);
        System.out.println(user);
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }

    /**
     * 使用 HQL 查询
     */
    @Test
    public void testHqlQuery() {
        //加载 Hibernate 核心配置文件
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //创建 HQL 语句，语法与 SQL 类似，但操作的是实体类及其属性
        Query query = session.createQuery("from User where userName like ?2 and email like ?3");
        query.setParameter(2, "%用户%");
        //查询所有使用 163 邮箱的用户
        query.setParameter(3, "%@qq%");
        //获取结果集
        List<User> resultList = query.getResultList();
        //遍历结果集
        for (User user : resultList) {
            System.out.println(user);
        }
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }

    /**
     * SQL 查询
     */
    @Test
    public void testSqlQuery() {
        //加载 Hibernate 核心配置文件
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //构建 sql 查询
        NativeQuery sqlQuery = session.createSQLQuery("select * from user where email like '%@qq%'");
        sqlQuery.addEntity(User.class);
        //获得结果集
        List<User> resultList = sqlQuery.getResultList();
        //遍历结果集
        for (User user : resultList) {
            System.out.println(user);
        }
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }
}
