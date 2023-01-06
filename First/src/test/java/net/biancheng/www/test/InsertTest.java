package net.biancheng.www.test;

import net.biancheng.www.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

public class InsertTest {
    /**
     * 保存数据
     */
    @Test
    public void testInsert() {
        //加载 Hibernate 核心配置文件
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //创建实体类对象
        User user = new User();
        user.setUserId("003");
        user.setUserName("编程帮新增用户");
        user.setPassword("654321");
        user.setEmail("14234567@qq.com");
        //向 user 表中插入数据,返回值为新增数据的主键 id
        Serializable save = session.save(user);
        System.out.println("新增数据的主键 id:"+save);
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }
}
