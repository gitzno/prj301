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
public class CategoryPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ID = req.getParameter("id");

        ProductsDAO daoProductsDAO = new ProductsDAO();
        CategoryDAO daoCategory = new CategoryDAO();
        ArrayList<Category> listCategory = daoCategory.getCategories();
        
        //pading
        int coutProduct = daoProductsDAO.getCountProductCategory(ID);
       
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int endPage = coutProduct / 9;
        if (coutProduct % 9 != 0) {
            endPage++;
        }
        if (index > endPage){
            index = endPage;
        }
        
        
        ArrayList<Product> listProduct = daoProductsDAO.getProductCate(ID, Integer.toString((index  - 1) * 9));
        Category category = daoCategory.getCategory(ID);
        req.setAttribute("category", category);
        req.setAttribute("listCategory", listCategory);
        req.setAttribute("listProduct", listProduct);
        req.setAttribute("page", endPage);
        req.setAttribute("tag", index);
        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }

//    public static void main(String[] urgs) {
//        ProductsDAO daoProductsDAO = new ProductsDAO();
//        CategoryDAO daoCategory = new CategoryDAO();
//        ArrayList<Category> listCategory = daoCategory.getCategories();
//        ArrayList<Product> listProduct = daoProductsDAO.getProductCate("1", "2");
//        System.out.println(listProduct.size());
//        for (Product pro : listProduct) {
//            System.out.println(pro.getProductID());
//        }
//    }
}
