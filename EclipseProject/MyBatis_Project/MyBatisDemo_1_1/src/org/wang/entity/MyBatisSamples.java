package org.wang.entity;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

 
public class MyBatisSamples
{
 
    /**
     * 方法描述：
     * 
     * @param:
     * @return:
     * @version: 1.0
     * @author: Administrator
     * @version: 2016年9月3日 上午11:42:18
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        String resource = "org/wang/entity/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try
        {
            Blog blog = session.selectOne("org.wang.entity.BlogMapper.selectBlog", 1);
            System.out.println(blog.getName());
            blog = session.selectOne("org.wang.entity.BlogMapper.selectBlog", 2);
            System.out.println(blog.getName());
        }
        finally
        {
            session.close();
        }
    }
 
}

