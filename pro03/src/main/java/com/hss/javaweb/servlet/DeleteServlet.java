package com.hss.javaweb.servlet;

import com.hss.javaweb.dao.FruitDao;
import com.hss.javaweb.dao.FruitDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends ViewBaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        FruitDao fruitDao = new FruitDaoImpl();
        int i = fruitDao.deleteFruitById(id);
        resp.sendRedirect("/pro03/ShowFruitList");
    }
}
