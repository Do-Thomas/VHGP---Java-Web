/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import controller.home.UpdateAdmin;
import dao.AdminDAO;
import dao.RoleDAO;
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
import model.Admin;
import model.Role;
import MyUitl.DBContext;

/**
 *
 * @author hathao
 */
@WebServlet(name = "UpdateAdmin", urlPatterns = {"/UpdateAdmin"})
public class UpdateAdmin extends HttpServlet {

    private final AdminDAO adminDAO = new AdminDAO();
    private final RoleDAO dao = new RoleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String usernameAdmin = request.getParameter("usernameAdmin");
            Admin item = adminDAO.details(usernameAdmin);
            request.setAttribute("item", item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdateAdmin.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UpdateAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String _UsernameAdmin = request.getParameter("UsernameAdmin");
        String _PassAdmin = request.getParameter("PassAdmin");
        String _MailAdmin = request.getParameter("MailAdmin");
        String _RoleID = request.getParameter("RoleID");
//                Role _RoleIDAdmin = dao.details(_RoleID);

        RoleDAO roleDAO = new RoleDAO();
        Role _RoleIDAdmin = dao.details(_RoleID);

        try {
            Admin item = new Admin(_UsernameAdmin, _PassAdmin, _MailAdmin, _RoleIDAdmin);
            adminDAO.update(item);
            response.sendRedirect(request.getContextPath() + "/ViewAdmin");
        } catch (NumberFormatException ex) {
            Logger.getLogger(UpdateAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
