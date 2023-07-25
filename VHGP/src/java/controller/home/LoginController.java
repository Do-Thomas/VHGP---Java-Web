/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Employee;
import model.Role;
import model.Services;

/**
 *
 * @author Asus
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String ADMIN_PAGE = "admin";
    private static final String AD = "admin";
    private static final String USER_PAGE = "IndexServices";
    private static final String US = "user";
    private static final String EMPLOYEE_PAGE = "EmployeeHome";

    //Chưa sửa login
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
            String sdt = request.getParameter("Phone");
            String matkhau = request.getParameter("Password");
            session.setAttribute("PHONE", sdt);
            session.setAttribute("PASSWORD", matkhau);

            if (sdt != null) {
                CustomerDAO dao = new CustomerDAO();
//                Customer customerL = dao.getAccountbyPhone(sdt);
//                String roleCustomer = customerL.getRole().getRoleID();
//                boolean flatRoleCustomer = roleCustomer.equals("user");
                Customer loginUser = dao.checkLogin(sdt, matkhau);
                //xac thuc o day ne
                if (loginUser != null) {
                    session.setAttribute("LOGIN_USER", loginUser);
                    session.setAttribute("PHONE_USER", sdt);
                    String roleID = loginUser.getRole().getRoleID();
                    //phan quyen ne
                    if (AD.equals(roleID)) {
                        url = ADMIN_PAGE;
                    } else if (US.equals(roleID)) {
                        ServicesDAO dvdao = new ServicesDAO();
                        List<Services> listServices = dvdao.read();
                        if (listServices.size() > 0) {
                            request.setAttribute("TOP_SERVICES", listServices);
                            url = USER_PAGE;
                        } else {
                            request.setAttribute("ERROR", "Incorrect phone or password");

                        }
                    }
                } else {
                    EmployeeDAO empDAO = new EmployeeDAO();
                    Employee employee = empDAO.getAccountByPhone(sdt);
                    if (employee != null) {
                        session.setAttribute("EMPLOYEE", employee);
                        session.setAttribute("PHONE_EMPLOYEE", sdt);
                        String roleID = employee.getEmployeePhone();

                        List<Employee> listEmployee = empDAO.read();
                        if (listEmployee.size() > 0) {
                            request.setAttribute("LIST_EMPLOYEE", listEmployee);
                            url = EMPLOYEE_PAGE;
                        } else {
                            request.setAttribute("ERROR", "Incorrect phone or password");
                        }
                    }
                }
            }
        } catch (Exception e) {
            url = EMPLOYEE_PAGE;
            log("Error at LoginController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
