/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.Category;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Chold
 */
public class CategoryDAO extends DBContext{
    public Category getCategory(String id){
        Category cate = null;
        try {
            String sql = "select * from Categories where CategoryID = " + id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName");
                String Description = rs.getString("Description");
                String Picture = rs.getString("Picture");
                cate = new Category(CategoryID, CategoryName, Description, Picture);
            }
        } catch (Exception e) {
        }
        return cate;
    }
    public ArrayList<Category> getCategories() {
        ArrayList<Category> list = new ArrayList<>();
        try {
            String sql = "select * from Categories";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName");
                String Description = rs.getString("Description");
                String Picture = rs.getString("Picture");
                Category cate = new Category(CategoryID, CategoryName, Description, Picture);
                list.add(cate);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
