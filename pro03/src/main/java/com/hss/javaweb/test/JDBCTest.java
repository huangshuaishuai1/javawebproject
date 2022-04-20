package com.hss.javaweb.test;

import com.hss.javaweb.bean.Fruit;
import com.hss.javaweb.dao.FruitDao;
import com.hss.javaweb.dao.FruitDaoImpl;
import com.hss.javaweb.utils.JDBCUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

public class JDBCTest {
    @Test
    public void testConnection() {
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testGetOneFruit() {
        FruitDao fruitDao = new FruitDaoImpl();
        Fruit fruitById = fruitDao.getFruitById(1);
        System.out.println(fruitById);
    }

    @Test
    public void testGetAllFruit() {
        FruitDao fruitDao = new FruitDaoImpl();
        List<Fruit> allFruit = fruitDao.getAllFruit();
        Iterator<Fruit> iterator = allFruit.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testAddFruit() {
        FruitDao fruitDao = new FruitDaoImpl();
        Fruit fruit = new Fruit(3, "菠萝", 4, 20);
        int i = fruitDao.addFruit(fruit);
        System.out.println(i);
    }

    @Test
    public void testUpdateFruitById() {
        FruitDao fruitDao = new FruitDaoImpl();
        int update = fruitDao.updateFruitById(1, "苹果", 100, 10);
        System.out.println(update);
    }

    @Test
    public void testDeleteFruitById() {
        FruitDao fruitDao = new FruitDaoImpl();
        int i = fruitDao.deleteFruitById(5);
        System.out.println(i);
    }
}
