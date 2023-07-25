/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import controller.admin.ListOfServicesAdmin;
import dao.OrdersDAO;
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
import javax.servlet.http.HttpSession;
import model.Employee;
import model.Order;


/**
 *
 * @author Asus
 */
@WebServlet(name = "EmployeeHome", urlPatterns = {"/EmployeeHome"})
public class EmployeeHome extends HttpServlet {

    private static final String ADMIN_PAGE = "/employeeHome.jsp";
    private static final String ERROR = "login.jsp";
    private  final StatusDAO StatusDAO = new StatusDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession();
            Employee employee = (Employee) session.getAttribute("EMPLOYEE");
            int EmployeeID = employee.getEmployeeID();
            OrdersDAO orderDAO = new OrdersDAO();
            List<Order> order = orderDAO.getEmployeeHome(EmployeeID);
            request.setAttribute("EMPLOYEE_ORDER", order);
            
            int Count = StatusDAO.getCountOrder(EmployeeID);
            request.setAttribute("COUNT_ORDER", Count);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/employeeHome.jsp");
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
