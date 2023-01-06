package net.biancheng.www.test;

import net.biancheng.www.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class DeleteTest {
    /**
     * 删除记录
     */
    @Test
    public void testDelete() {
        //加载 Hibernate 核心配置文件
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setId(3);
        //删除指定的记录
        session.delete(user);
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }
}
