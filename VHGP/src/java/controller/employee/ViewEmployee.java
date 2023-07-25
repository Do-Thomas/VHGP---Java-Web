/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

/**
 *
 * @author hathao
 */
@WebServlet(name = "ViewEmployee", urlPatterns = {"/ViewEmployee"})
public class ViewEmployee extends HttpServlet {
    
    private final EmployeeDAO employeeDAO = new EmployeeDAO();
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ViewEmployee.jsp";


    protected void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String url = ERROR;

        try {
            String EmployeePhone = (String) session.getAttribute("PHONE_EMPLOYEE"); 
            Employee emp = (Employee) employeeDAO. getEmployeeByPhone(EmployeePhone);
            List<Employee> list = new ArrayList<>();
            list.add(emp);
            request.setAttribute("DETAILS_EMPOYEEE", list);

            url = SUCCESS;
        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }
    }
