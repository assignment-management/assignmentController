/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.API;

import com.neupane.relationship.DAO.AssignmentDAO;
import com.neupane.relationship.DAO.Impl.AssignmentDAOImpl;
import com.neupane.relationship.entity.Assignments;
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
@WebServlet(name = "assignmentController", urlPatterns = "/assignments/*")
public class AssignmentController extends HttpServlet {

    private AssignmentDAO assignmentDAO = new AssignmentDAOImpl();

    private Assignments assignment = new Assignments();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPage = "/WEB-INF/assignment/assignments.jsp";
        boolean redirect = false;

        try {

            String path = request.getRequestURI().toLowerCase();

            if (path.contains("/add")) {
                viewPage = "/WEB-INF/assignment/add.jsp";
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
                viewPage = "/WEB-INF/assignment/edit.jsp";
                assignment = assignmentDAO.getById(Integer.parseInt(request.getParameter("id")));
                System.out.println(assignment.getTitle());
                request.setAttribute("department", assignment);

            } else {

                request.setAttribute("assignments", assignmentDAO.getAll());
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

        Assignments assign = new Assignments();
        assign.setTitle(request.getParameter("title"));
        assign.setDescription(request.getParameter("description"));
        assign.setTotalStudent(Integer.parseInt(request.getParameter("total_students")));

        try {
            assignmentDAO.insert(assignment);
            response.sendRedirect(request.getContextPath() + "/assignments");
        } catch (IOException io) {
            System.out.println(io);
        }
    }

}
