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
public class MainHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO daoCategory = new CategoryDAO();
        ProductsDAO daoProducts = new ProductsDAO();
        ArrayList<Category> list = daoCategory.getCategories();
        ArrayList<Product> listHot = daoProducts.getProducts(2);
        ArrayList<Product> listSale = daoProducts.getProducts(3);
        ArrayList<Product> listNew = daoProducts.getProducts(1);
        req.setAttribute("list", list);
        req.setAttribute("listHot", listHot);
        req.setAttribute("listSale", listSale);
        req.setAttribute("listNew", listNew);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    
    
}
