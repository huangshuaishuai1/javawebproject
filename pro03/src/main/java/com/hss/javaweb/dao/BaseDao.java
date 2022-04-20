package com.hss.javaweb.dao;

import com.hss.javaweb.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {
    // DBUtils 工具包提供的数据库操作对象
    private QueryRunner runner = new QueryRunner();

    public T getSingleBean(String sql, Class<T> entityClass, Object ... parameters) {
        try {
            //1. 获取数据库连接
            Connection connection = JDBCUtil.getConnection();
            return runner.query(connection, sql, new BeanHandler<>(entityClass), parameters);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<T> getAllBeans(String sql, Class<T> entityClass) {
        try {
            Connection connection = JDBCUtil.getConnection();
            return runner.query(connection, sql, new BeanListHandler<>(entityClass));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int update(String sql, Object...parameters) {
        try {
            Connection connection = JDBCUtil.getConnection();
            int i = runner.update(connection, sql, parameters);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}
