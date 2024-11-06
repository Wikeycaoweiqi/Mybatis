package com.wikeystudy.mybatis.test;

import com.wikeystudy.mybatis.pojo.Car;
import com.wikeystudy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author：Wikey Cao
 * @ Date：05-11-2024
 * @ Description：
 */
public class CarMapperTest {

    @Test
    public void insertCarByMapTest() {
        SqlSession sqlSession = SqlSessionUtil.openSeasion();
        Map<String, Object> map = new HashMap<>();
        map.put("carNum", "CN011");
        map.put("brand", "奥迪");
        map.put("guidePrice", 250000.00);
        map.put("produceTime", "2023-08-01");
        map.put("carType", "电车");
        int rows = sqlSession.insert("car.insertCar", map);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(rows);
    }

    @Test
    public void insertCarByPojoTest() {
        SqlSession sqlSession = SqlSessionUtil.openSeasion();
        Car car = new Car(null, "CN013", "奔驰", 350000.00, "2023-08-03", "氢能源");
        int rows = sqlSession.insert("car.insertCar", car);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(rows);
    }

    @Test
    public void deleteCarTest() {
        SqlSession sqlSession = SqlSessionUtil.openSeasion();
        int rows = sqlSession.delete("car.deleteCar", 35);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(rows);
    }

    @Test
    public void updateCarTest() {
        SqlSession sqlSession = SqlSessionUtil.openSeasion();
        Car car = new Car(37L, "CN013", "xxx", 1.00, "2099-09-09", "元气丹");
        int rows = sqlSession.update("car.updateCar", car);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(rows);
    }

    @Test
    public void queryCarByIdTest() {
        SqlSession sqlSession = SqlSessionUtil.openSeasion();
        Object car = sqlSession.selectOne("car.selectCarById", 1);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(car);
    }

    @Test
    public void queryAllCarTest() {
        SqlSession sqlSession = SqlSessionUtil.openSeasion();
        List<Object> carList = sqlSession.selectList("car.selectAllCar");
        sqlSession.commit();
        sqlSession.close();
        System.out.println(carList);
    }
}