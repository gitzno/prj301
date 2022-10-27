
package models;

import dal.Account;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO extends DBContext{
    public Account getAccount(String email, String pass){
        Account acc = null;
        try {
            String sql = "select * from Accounts where Email=? and Password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");
                acc = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role);
            }
        } catch (Exception e) {
        }
        return acc;
    }
    
    public static void main(String[] args) {
        System.out.println(new AccountDAO().getAccount("cust1@gmail.com", "123"));
    }
}
