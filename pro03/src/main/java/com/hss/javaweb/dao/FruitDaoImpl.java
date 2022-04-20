package com.hss.javaweb.dao;

import com.hss.javaweb.bean.Fruit;

import java.util.List;

public class FruitDaoImpl extends BaseDao<Fruit> implements FruitDao {

    @Override
    public Fruit getFruitById(int id) {
        String sql = "select id,name,count,price from fruit where id=?";
        Fruit fruit = getSingleBean(sql, Fruit.class, id);
        return fruit;
    }

    @Override
    public List<Fruit> getAllFruit() {
        String sql = "select id,name,count,price from fruit";
        List<Fruit> allBeans = getAllBeans(sql, Fruit.class);
        return allBeans;
    }

    @Override
    public int addFruit(Fruit fruit) {
        int id = fruit.getId();
        String name = fruit.getName();
        int count = fruit.getCount();
        int price = fruit.getPrice();
        String sql = "insert into fruit values (?,?,?,?)";
        int i = update(sql, id, name, count, price);
        return i;
    }

    @Override
    public int updateFruitById(int id, String name, int count, int price) {
        String sql = "update fruit set name=?,count=?,price=? where id=?";
        int update = update(sql, name, count, price, id);
        return update;
    }

    @Override
    public int deleteFruitById(int id) {
        String sql = "delete from fruit where id=?";
        int update = update(sql, id);
        return update;
    }
}
