package models;

import dal.DBContext;
import dal.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Chold
 */
public class ProductsDAO extends DBContext {

    public static String queryProduct(int type) {
        switch (type) {
            case 1: //get product new
                return "select * from  Products order by ProductID DESC";
            case 2: // get product hot
                return "select * from Products ,(select ProductID , COUNT(ProductID) AS AppearTime\n"
                        + "						from [Order Details]\n"
                        + "						GROUP BY ProductID\n"
                        + "						 ) as mot where Products.ProductID = mot.ProductID\n"
                        + "						 order by AppearTime desc";
            case 3: //get product best sale
                return "SELECT DISTINCT Products.ProductID, Products.ProductName, Products.CategoryID, Products.QuantityPerUnit, Products.UnitPrice, Products.UnitsInStock,\n"
                        + "		Products.UnitsOnOrder, Products.ReorderLevel, Products.Discontinued , [Order Details].Discount, [Order Details].Discount * Products.UnitPrice\n"
                        + "		as\"TotalDiscount\" \n"
                        + "		FROM Products\n"
                        + "		INNER JOIN [Order Details]\n"
                        + "		ON Products.ProductID = [Order Details].ProductID\n"
                        + "		order by \"TotalDiscount\" DESC ";
            case 4: // none
                return "select * from Products";

            default:
                return "errol";

        }
    }
    public Product getProduct(String index) {
        Product pro = null;
        try {
            String sql = "select * from Products\n"
                    + "where ProductID =" + index;

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                pro = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                return pro;
            }
        } catch (Exception e) {
        }
        return pro;

    }

    public ArrayList<Product> getProductCate(String index, String page) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Products where Products.CategoryID = " + index + " ORDER BY ProductID OFFSET " + page + " ROWS FETCH NEXT 9 ROWS ONLY";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

//            ps.setInt(1, index);
//            ps.setInt(2, (1 - 1) * 9);
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product pro = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                list.add(pro);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> getProducts(String type, String id) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Products\n"
                    + "WHERE ProductName like '%" + type + "%'"
                    + "and CategoryID = " + id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product pro = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                list.add(pro);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> getProducts(String type) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Products\n"
                    + "WHERE ProductName like '%" + type + "%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product pro = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                list.add(pro);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> getProducts(int type) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = queryProduct(type);
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int count = 4;
            while (rs.next() && count != 0) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product pro = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                list.add(pro);
                count--;
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getCountProductCategory(String id) {
        int a = 0;
        String sql = "select count(*) from Products where Products.CategoryID = " + id;
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
            a = ps.executeUpdate();
        } catch (Exception e) {

        }
        return a;
    }

    public static void main(String[] urgs) {

        ProductsDAO dao = new ProductsDAO();
        ArrayList<Product> arr = dao.getProductCate("1", "2");
        System.out.println(arr.size());
    }
}
