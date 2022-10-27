/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.Customer;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Chold
 */
public class CustomerDAO extends DBContext {

    public int updateCustomer(Customer cus) {
        int num = 0;
        try {
            String sql = "update Customers set \n"
                    + "CompanyName = ?, ContactName = ?, ContactTitle = ?, Address = ?\n"
                    + "where CustomerID = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cus.getCompanyName());
            ps.setString(2, cus.getContactName());
            ps.setString(3, cus.getContactTitle());
            ps.setString(4, cus.getAddress());
            ps.setString(5, cus.getCustomerID());
            num = ps.executeUpdate();
            

        } catch (Exception e) {
        }
        return num;
    }

    public Customer getCustomer(String id) {
        Customer cus = null;
        try {
            String sql = "select * from Customers where CustomerID = '" + id + "'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String CustomerID = rs.getString("CustomerID");
                String CompanyName = rs.getString("CompanyName");
                String ContactName = rs.getString("ContactName");
                String ContactTitle = rs.getString("ContactTitle");
                String Address = rs.getString("Address");
                cus = new Customer(CustomerID, CompanyName, ContactName, ContactTitle, Address);
            }
        } catch (Exception e) {
        }
        return cus;
    }

    public static void main(String[] urgs) {
        Customer cus = new CustomerDAO().getCustomer("ERNSH");
        System.out.println(cus.getCompanyName());
        cus.setCompanyName(cus.getCompanyName() + 'a');

        System.out.println(new CustomerDAO().updateCustomer(cus));
        System.out.println(cus.getCompanyName());

    }


}
