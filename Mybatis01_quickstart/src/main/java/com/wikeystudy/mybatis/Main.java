package com.wikeystudy.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @ Author：Wikey Cao
 * @ Date：05-11-2024l
 * @ Description：
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int rows = sqlSession.insert("insertCar");

        sqlSession.commit();

        System.out.println(rows);
    }
}