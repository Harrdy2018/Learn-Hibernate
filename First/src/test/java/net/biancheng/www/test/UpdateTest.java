package net.biancheng.www.test;

import net.biancheng.www.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class UpdateTest {
    /**
     * 修改记录
     */
    @Test
    public void testUpdate() {
        //加载 Hibernate 核心配置文件
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //创建实体对象
        User user = new User();
        user.setId(4);
        //设置需要修改的字段
        user.setUserName("更新用户名");
        //直接调用 update() 方法进行修改
        session.update(user);
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }

    /**
     * 先查询再修改记录
     */
    @Test
    public void testUpdate2() {
        //加载 Hibernate 核心配置文件
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //现将需要修改的记录查询出来
        User user = session.get(User.class, 1);
        //设置需要修改的字段
        user.setUserName("更新用户名");
        //直接调用 update() 方法进行修改
        session.update(user);
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }
}
