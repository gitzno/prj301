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
public class editProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account) req.getSession().getAttribute("AccSession");
        Employee em = null;
        Customer cus = null;
        ArrayList<Department> de = new DepartmentDAO().getListDepartment();
//        de.get(2).getDepartmentID();
        if (acc.getRole() == 1) {
            em = new EmployeeDAO().getEmployee(Integer.toString(acc.getEmployeeID()));

        }
        if (acc.getRole() == 2) {
            cus = new CustomerDAO().getCustomer(acc.getCustomerID());
        }
        req.setAttribute("departList", de);
        req.setAttribute("cus", cus);
        req.setAttribute("em", em);
        req.getSession().setAttribute("AccSession", acc);
        req.getRequestDispatcher("/editProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account) req.getSession().getAttribute("AccSession");
        Employee em = null;
        Customer cus = null;
        
        ArrayList<Department> de = new DepartmentDAO().getListDepartment();
        if (acc.getRole() == 1) {
            em = new EmployeeDAO().getEmployee(Integer.toString(acc.getEmployeeID()));
            String LastName = req.getParameter("txtLastName");
            String FirstName = req.getParameter("txtFirtName");
            int DepartmentID = Integer.parseInt(req.getParameter("DepartmentID"));
            String Title = req.getParameter("txtTitle");
            String TitleOfCourtesy = req.getParameter("TitleOfCourtesy");
            String Address = req.getParameter("txtAdd");
            em = new Employee(em.getEmployeeID(), LastName, FirstName, DepartmentID, Title, em.getTitleOfCourtesy(), em.getBirthDate(), em.getHireDate(), Address);
            int dao = (new EmployeeDAO().updateEmployee(em));
            if (dao == 1) {
                req.setAttribute("mess", "update Customer successfully!");
            } else {
                req.setAttribute("mess", "update errol!");
            }
            req.setAttribute("em", em);
        }
        if (acc.getRole() == 2) {
            cus = new CustomerDAO().getCustomer(acc.getCustomerID());
            String CompanyName = req.getParameter("txtCompany");
            String ContactName = req.getParameter("txtContact");
            String ContactTitle = req.getParameter("txtTitle");
            String Address = req.getParameter("txtAdd");
            Customer cuss = new Customer(cus.getCustomerID(), CompanyName, ContactName, ContactTitle, Address);
            int dao = (new CustomerDAO().updateCustomer(cuss));
            if (dao == 1) {
                req.setAttribute("mess", "update Customer successfully!");
            } else {
                req.setAttribute("mess", "update errol!");
            }
            req.setAttribute("cus", cuss);
        }
        
        req.setAttribute("listDe", de);
        req.getSession().setAttribute("AccSession", acc);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

}
