package com.hss.javaweb.dao;

import com.hss.javaweb.bean.Fruit;
import com.hss.javaweb.utils.JDBCUtil;

import java.sql.Connection;
import java.util.List;

public interface FruitDao {
    public Fruit getFruitById (int id);
    public List<Fruit> getAllFruit ();
    public int addFruit(Fruit fruit);
    public int updateFruitById(int id, String name, int count, int price);
    public int deleteFruitById(int id);
}
