/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.home.*;
import dao.EmployeeDAO;
import dao.ServicesDAO;
import dao.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;
import model.Services;
import model.Status;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ListOfServices", urlPatterns = {"/admin"})
public class ListOfServicesAdmin extends HttpServlet {
    
    private final ServicesDAO ServicesDAO = new ServicesDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            List<Services> listItem = ServicesDAO.read();
            request.setAttribute("LIST_SERVICES", listItem);
            
            StatusDAO statusDAO = new StatusDAO();
            List<Status> listOrder = statusDAO.getListOrder();
            request.setAttribute("LIST_ORDER", listOrder);
            
            EmployeeDAO employeeDAO = new EmployeeDAO();
//            List<Employee> listEmployee = employeeDAO.getEmployeeWork();
//            request.setAttribute("LIST_EMPLOYEE", listEmployee);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listServices.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListOfServicesAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }
}
