/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dal.Category;
import dal.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.CategoryDAO;
import models.ProductsDAO;

/**
 *
 * @author Chold
 */
public class DetailPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ID = req.getParameter("id");
        ProductsDAO daoProductsDAO = new ProductsDAO();
//        CategoryDAO daoCategory = new CategoryDAO();
        Product pro = daoProductsDAO.getProduct(ID);
        if (pro != null) {
            req.setAttribute("Product", pro);
            req.getRequestDispatcher("detail.jsp").forward(req, resp);
        }
        else
            req.getRequestDispatcher("/home").forward(req, resp);
    }

}
