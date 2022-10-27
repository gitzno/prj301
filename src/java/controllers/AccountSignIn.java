package controllers;

import dal.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.AccountDAO;

public class AccountSignIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("AccSession") != null) {
            req.getSession().removeAttribute("AccSession");
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.getRequestDispatcher("../signin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Nhan du lieu tu login.jsp
        String email = req.getParameter("txtEmail");
        String pass = req.getParameter("txtPass");

//        if (email.equals("")) {
//            req.setAttribute("msgEmail", "Email is required");
//        }
//        if(pass.equals("")){
//            req.setAttribute("msgPass", "Password is required");
//        }
//        
        Account acc = new AccountDAO().getAccount(email, pass);
        if (acc != null) {
            // Cap session cho account
            req.getSession().setAttribute("AccSession", acc);
            // Dieu huong toi 'index.jsp'
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.setAttribute("msg", "This account does not exist");
            req.getRequestDispatcher("../signin.jsp").forward(req, resp);
        }
    }

}
