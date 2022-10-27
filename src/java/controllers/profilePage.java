/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.CustomerDAO;
import dal.Account;
import dal.Customer;
import dal.Department;
import dal.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.DepartmentDAO;
import models.EmployeeDAO;

/**
 *
 * @author Chold
 */
public class profilePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account) req.getSession().getAttribute("AccSession");
        Employee em = null;
        Customer cus = null;
        ArrayList<Department> de = new DepartmentDAO().getListDepartment();
        if (acc.getRole() == 1) {
            em = new EmployeeDAO().getEmployee(Integer.toString(acc.getEmployeeID()));
        }
        if (acc.getRole() == 2) {
            cus = new CustomerDAO().getCustomer(acc.getCustomerID());
        }
        req.setAttribute("listDe", de);
        req.setAttribute("cus", cus);
        req.setAttribute("em", em);
        req.getSession().setAttribute("AccSession", acc);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);

    }
}
