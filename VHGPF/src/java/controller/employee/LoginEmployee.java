/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
 * @author Asus
 */
@WebServlet(name = "LoginEmployee", urlPatterns = {"/LoginEmployee"})
public class LoginEmployee extends HttpServlet {

    private static final String EMPLOYEE_PAGE = "EmployeePage";
    private static final String ERROR = "login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = ERROR;
        try {
            String phone = request.getParameter("Phone");
            String matkhau = request.getParameter("Password");
            EmployeeDAO empDAO = new EmployeeDAO();
            Employee employee = empDAO.getAccountByPhone(phone);
            if (employee != null) {
                session.setAttribute("EMPLOYEE", employee);
                session.setAttribute("PHONE_EMPLOYEE", phone);
                String roleID = employee.getEmployeePhone();

                List<Employee> listEmployee = empDAO.read();
                if (listEmployee.size() > 0) {
                    request.setAttribute("LIST_EMPLOYEE", listEmployee);
                    url = EMPLOYEE_PAGE;
                } else {
                    request.setAttribute("ERROR", "Incorrect phone or password");
                }
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

//                }
    }

}
