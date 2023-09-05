/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.AdminDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.ServicesDAO;
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
import model.Admin;
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
    private static final String ADMIN_PAGE = "Dashboard";
    private static final String AD = "admin";
    private static final String USER_PAGE = "IndexServices";
    private static final String US = "user";
    private static final String EMPLOYEE_PAGE = "AllJobController";
    private static final String E = "emp";
    private static final String MANAGE_PAGE = "ManageHome";
    private static final String MG = "manage";

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

        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String sdt = request.getParameter("Phone");
            String matkhau = request.getParameter("Password");
            session.setAttribute("PHONE", sdt);
            session.setAttribute("PASSWORD", matkhau);
            CustomerDAO dao = new CustomerDAO();
            Customer loginUser = dao.checkLogin(sdt, matkhau);
            String mail = request.getParameter("MailAdmin");
            AdminDAO ADdao = new AdminDAO();
            Admin loginAD = ADdao.checkLogin(sdt, matkhau);
            EmployeeDAO Edao = new EmployeeDAO();
            Employee loginE = Edao.checkLogin(sdt, matkhau);
            //xac thuc o day ne
            if (loginUser != null) {
                session.setAttribute("LOGIN_USER", loginUser);
                session.setAttribute("PHONE_USER", sdt);
                String roleID = loginUser.getRole().getRoleID();
                //phan quyen ne
                if (US.equals(roleID)) {
                    ServicesDAO dvdao = new ServicesDAO();
                    List<Services> listServices = dvdao.read();
                    if (listServices.size() > 0) {
                        request.setAttribute("TOP_SERVICES", listServices);
                        session.setAttribute("PHONE_USER", sdt);
                        url = USER_PAGE;
                    }
                }
            } else if (loginAD != null) {
                session.setAttribute("LOGIN_USER", loginAD);
                session.setAttribute("PHONE_ADMIN", sdt);
                String roleID = loginAD.getRoleID().getRoleID();
                //phan quyen ne
                if (AD.equals(roleID)) {
                    url = ADMIN_PAGE;
                } else if (MG.equals(roleID)) {
                    url = MANAGE_PAGE;
                }
            } else if (loginE != null) {
                session.setAttribute("LOGIN_USER", loginE);
                session.setAttribute("PHONE_EMPLOYEE", sdt);
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

            } else {
                request.setAttribute("ERROR", "Incorrect phone or password");
            }

        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
