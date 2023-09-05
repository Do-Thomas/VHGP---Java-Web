/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dao.AdminDAO;
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

/**
 *
 * @author Asus
 */
@WebServlet(name = "LoginAdminController", urlPatterns = {"/LoginAdminController"})
public class LoginAdminController extends HttpServlet {

    private static final String ADMIN_PAGE = "/Dashboard";
    private static final String ERROR = "login.jsp";
    private static final String MANAGE_PAGE = "ManageHome";

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
            AdminDAO adminDAO = new AdminDAO();
            Admin admin = adminDAO.getAccountAdminByPhone(phone);
            if (phone.endsWith("0987654321") && matkhau.equals("12345")) {
                session.setAttribute("PHONE_ADMIN", phone);
                List<Admin> listAdmin = adminDAO.getAccountAdmin();
                if (listAdmin.size() > 0) {
                    request.setAttribute("LIST_ADMIN", listAdmin);
                    url = ADMIN_PAGE;
                } else {
                    request.setAttribute("ERROR", "Incorrect phone or password");
                }
            } else {
                url = MANAGE_PAGE;
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}


//        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.ADMIN.role.roleID != 'admin'}">
//            <c:redirect url="login.jsp"></c:redirect>
//        </c:if>
