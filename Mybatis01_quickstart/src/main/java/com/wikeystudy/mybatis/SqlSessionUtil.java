package com.wikeystudy.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @ Author：Wikey Cao
 * @ Date：05-11-2024
 * @ Description：
 */
public class SqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory;

    private SqlSessionUtil() {

    }

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession openSeasion() {
        return sqlSessionFactory.openSession();
    }
}