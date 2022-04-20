package com.hss.javaweb.servlet;

import com.hss.javaweb.bean.Fruit;
import com.hss.javaweb.dao.FruitDao;
import com.hss.javaweb.dao.FruitDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddFruitServlet extends ViewBaseServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processTemplate("add",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer count = Integer.parseInt(req.getParameter("count"));
        Integer price = Integer.parseInt(req.getParameter("price"));

        Fruit fruit = new Fruit(id, name, count, price);
        FruitDao fruitDao = new FruitDaoImpl();
        int i = fruitDao.addFruit(fruit);

        System.out.println(i);

        resp.sendRedirect("/pro03/ShowFruitList");

    }
}
