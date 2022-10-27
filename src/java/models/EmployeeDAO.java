/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.DBContext;
import dal.Department;
import dal.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Chold
 */
public class EmployeeDAO extends DBContext {

    public int updateEmployee(Employee em) {
        int num = 0;
        try {
            String sql = "update Employees set \n"
                    + "LastName = ?, FirstName = ?, DepartmentID = ?, Title = ?, TitleOfCourtesy = ?, BirthDate = ?, HireDate = ?, Address = ?\n"
                    + "where EmployeeID = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, em.getLastName());
            ps.setString(2, em.getFirstName());
            ps.setInt(3, em.getDepartmentID());
            ps.setString(4, em.getTitle());
            ps.setString(5, em.getTitleOfCourtesy());
            ps.setString(6, em.getBirthDate());
            ps.setString(7, em.getHireDate());
            ps.setString(8, em.getAddress());
            ps.setInt(9, em.getEmployeeID());
            num = ps.executeUpdate();

        } catch (Exception e) {
        }
        return num;
    }

    public Employee getEmployee(String id) {
        Employee em = null;
        try {
            String sql = "select * from Employees where EmployeeID = '" + id + "'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int EmployeeID = rs.getInt("EmployeeID");
                String LastName = rs.getString("LastName");
                String FirstName = rs.getString("FirstName");
                int DepartmentID = rs.getInt("DepartmentID");
                String Title = rs.getString("Title");
                String TitleOfCourtesy = rs.getString("TitleOfCourtesy");
                String BirthDate = rs.getString("BirthDate");
                String HireDate = rs.getString("HireDate");
                String Address = rs.getString("Address");
                em = new Employee(EmployeeID, LastName, FirstName, DepartmentID, Title, TitleOfCourtesy, BirthDate, HireDate, Address);
            }
        } catch (Exception e) {
        }
        return em;
    }

    public static void main(String[] urgs) {
//        ArrayList<Department> de = new EmployeeDAO().getListDepartment();
//        for (Department i : de) {
//            System.out.println(i.getDepartmentID() + "/" + i.getDepartmentName() + "/" + i.getDepartmentType());
//        }
//        String z = new EmployeeDAO().getDepartment("1");
//        System.out.println(z);
          Employee em = new EmployeeDAO().getEmployee("2");
          System.out.println(em.getLastName());
          
//          em.setLastName(em.getLastName() + "A");
          System.out.println(em.getLastName());
          int a = new EmployeeDAO().updateEmployee(em);
          if(a == 1)
              System.out.println(em.getDepartmentID());
              else
              System.out.println("errol");
//        
    }
}
