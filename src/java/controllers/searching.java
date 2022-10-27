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
public class searching extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO daoCategory = new CategoryDAO();
        ProductsDAO daoProducts = new ProductsDAO();
        ArrayList<Product> list = new ArrayList<>();
        ArrayList<Category> listcate = daoCategory.getCategories();
        String s = req.getParameter("txtSearch");
        String ID = req.getParameter("id");
        if (s != null && ID != null) {
            list = daoProducts.getProducts(s, ID);
        } else if (s != null && ID == null) {
            list = daoProducts.getProducts(s);
        } else {
            list = daoProducts.getProducts(4);
        }
        req.setAttribute("list", list);
        req.setAttribute("listcate", listcate);
        req.getRequestDispatcher("searching.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
