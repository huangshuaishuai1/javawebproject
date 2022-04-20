package com.hss.javaweb.servlet;

import com.hss.javaweb.bean.Fruit;
import com.hss.javaweb.dao.FruitDao;
import com.hss.javaweb.dao.FruitDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends ViewBaseServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        FruitDao fruitDao = new FruitDaoImpl();

        Fruit fruitById = fruitDao.getFruitById(id);
        req.setAttribute("fruit",fruitById);
        processTemplate("edit",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer count = Integer.parseInt(req.getParameter("count"));
        Integer price = Integer.parseInt(req.getParameter("price"));
        FruitDao fruitDao = new FruitDaoImpl();
        int i = fruitDao.updateFruitById(id, name, count, price);
        resp.sendRedirect("/pro03/ShowFruitList");
    }
}
