/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.API;

import com.neupane.relationship.Helper.Email;
import com.neupane.relationship.system.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

/**
 *
 * @author parlad
 */
@WebServlet(name = "mail", urlPatterns = "/mail/*")
public class MailController extends Controller {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("mail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response.getWriter().println(request.getParameter("mailSender"));

        Email email = new Email();
        email.setFrom(request.getParameter("email"));
        email.setHost("smtp.wlink.com.np");
        email.setSubject(request.getParameter("subject"));
        email.setDescription(request.getParameter("description"));
        email.send();
        response.getWriter().println("<h1>Thank you</h1>");
    }

}
