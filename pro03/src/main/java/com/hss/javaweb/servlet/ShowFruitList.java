package com.hss.javaweb.servlet;

import com.hss.javaweb.bean.Fruit;
import com.hss.javaweb.dao.FruitDao;
import com.hss.javaweb.dao.FruitDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowFruitList")
public class ShowFruitList extends ViewBaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FruitDao fruitDao = new FruitDaoImpl();
        List<Fruit> allFruit = fruitDao.getAllFruit();
        HttpSession session = req.getSession();
        session.setAttribute("fruitList",allFruit);
        super.processTemplate("show",req,resp);
    }
}
