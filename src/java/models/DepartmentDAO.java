/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.DBContext;
import dal.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Chold
 */
public class DepartmentDAO extends DBContext{
     public ArrayList<Department> getListDepartment() {
        ArrayList<Department> de = new ArrayList<>();
        try {
            String sql = "select * from Departments";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int DepartmentID = rs.getInt("DepartmentID");
                String DepartmentName = rs.getString("DepartmentName");
                String DepartmentType = rs.getString("DepartmentType");
                Department des = new Department(DepartmentID, DepartmentName, DepartmentType);
                de.add(des);
            }

        } catch (Exception e) {
        }
        return de;
    }

    public String getDepartment(String id) {
        String de = null;
        try {
            String sql = "select DepartmentName from Departments where DepartmentID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            de = rs.getString("DepartmentName");
            
        } catch (Exception e) {
        }
        return de;
    }
      public static void main(String[] urgs) {
//        ArrayList<Department> de = new DepartmentDAO().getListDepartment();
//        for (Department i : de) {
//            System.out.println(i.getDepartmentID() + "/" + i.getDepartmentName() + "/" + i.getDepartmentType());
//        }
        String z = new DepartmentDAO().getDepartment("1");
        System.out.println(z);
    }
}
