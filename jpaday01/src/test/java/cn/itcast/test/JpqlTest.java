package cn.itcast.test;

import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.awt.*;

public class JpqlTest {
    /**
     * 测试Jpql
     */
    @Test
    public void testFindAll(){
        //1.获取entityManager对象
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.查询全部
        String jpql = "";
        Query query = em.createQuery(jpql);
        //发送查询，并封装结果集
    }
}
