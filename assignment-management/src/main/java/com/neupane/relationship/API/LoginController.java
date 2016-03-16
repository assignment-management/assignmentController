/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.API;

import com.neupane.relationship.system.Controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author parlad
 */
@WebServlet(name = "login", urlPatterns = "/login/*")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPage = "/WEB-INF/view/login/login.jsp";
        boolean redirect = false;
        if (!redirect) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (password.equalsIgnoreCase("admin") && email.equalsIgnoreCase("admin@gmail.com")) {

            request.getSession().setAttribute("loggedin", true);
            response.sendRedirect(request.getContextPath() + "/assignments");

        } else {
            response.sendRedirect(request.getContextPath() + "/login?error");
        }
    }

}
