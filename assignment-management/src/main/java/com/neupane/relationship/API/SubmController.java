/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.API;

import com.neupane.relationship.DAO.Impl.SubmissionDAOImpl;
import com.neupane.relationship.DAO.SubmissionDAO;
import com.neupane.relationship.entity.Submission;
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
@WebServlet(name = "submController", urlPatterns = "/submission/*")
public class SubmController extends HttpServlet {

    private SubmissionDAO submissionDAO = new SubmissionDAOImpl();

    private Submission submission = new Submission();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPage = "/WEB-INF/submission/submission.jsp";
        boolean redirect = false;

        try {

            String path = request.getRequestURI().toLowerCase();

            if (path.contains("/add")) {
                viewPage = "/WEB-INF/submission/add.jsp";
            } else if (path.contains("/edit")) {

//                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
//                    int id = Integer.parseInt(request.getParameter("id"));
//                    Department dept = deptDao.getById(id);
//
//                    if (dept == null) {
//                        redirect = true;
//                        response.sendRedirect(request.getContextPath() + "/department?error");
//
//                    }
//
//                    request.setAttribute("department", dept);
//
//                } else {
//                    redirect = true;
//                    viewPage = "/WEB-INF/view/department/edit.jsp";
//                   // response.sendRedirect(request.getContextPath() + "/department?error");
//                }
//                
                viewPage = "/WEB-INF/submission/edit.jsp";
                submission = submissionDAO.getById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("submission", submission);

            } else {

                request.setAttribute("submission", submissionDAO.getAll());
            }

        } catch (Exception oo) {
            System.out.println(oo.getMessage());
        }
        if (!redirect) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
            dispatcher.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Submission assign = new Submission();
        assign.setContent(request.getParameter("content"));
        try {
            submissionDAO.insert(submission);
            response.sendRedirect(request.getContextPath() + "submission");
        } catch (IOException io) {
            System.out.println(io);
        }
    }

}
