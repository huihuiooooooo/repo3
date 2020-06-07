package cn.itcast.test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * * Jpa的操作步骤
 *         1.加载配置文件创建工厂(实体管理类工厂)对象
 *          2.通过实体管理类工厂获取实体管理器
 *           3.获取事务对象,开启事务
 *            4.完成CURD操作
 *              5.提交事务(回滚事务)
 *                6.释放资源
 */
public class JpaTest {

    /**
     * 测试jpa的保存
     *      :保存一个客户到数据库中
     */
    @Test
    public void testSave(){
//        //1.加载配置文件创建工厂(实体管理类工厂)对象
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
//        //2.通过实体管理类工厂获取实体管理器(与持久层打交道的对象)
//        EntityManager em = factory.createEntityManager();
        //1.2 通过工具类获取
        EntityManager em = JpaUtils.getEntityManager();

        //3.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //4.保存客户到数据库
        Customer customer = new Customer();
        customer.setCustName("传智播客");
        customer.setCustIndustry("教育");
        em.persist(customer);
        //5.提交事务
        tx.commit();
        //6.释放资源
        em.close();
//        factory.close(); 多线程的时候自己使用完并不用关闭,因为其他线程还要用
    }


    /**
     * 通过id查询用户
     */
    @Test
    public void testFind(){
        //1.通过工具类获取实体管理类
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.根据id查询用户
        Customer customer = em.find(Customer.class, 1);
        System.out.println(customer.toString());
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 延迟加载(懒加载)
     *      *得到的时一个动态代理对象
     *      *当要用到查询的属性时才会真正查询
     */
    @Test
    public void testReference(){
        //1.通过工具类获取实体管理类
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.根据id查询用户
        Customer customer = em.getReference(Customer.class, 1);
        System.out.println(customer.toString());
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 删除客户
     */
    @Test
    public void testRemove(){
        //1.通过工具类获取实体管理类
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.删除客户
        Customer customer = em.getReference(Customer.class, 1);
        em.remove(customer);
        System.out.println(customer.toString());
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 更新客户
     */
    @Test
    public void testUpdate(){
        //1.通过工具类获取实体管理类
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.更新客户
        Customer customer = em.getReference(Customer.class, 2);
        customer.setCustIndustry("IT");
        em.merge(customer);
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }
}
