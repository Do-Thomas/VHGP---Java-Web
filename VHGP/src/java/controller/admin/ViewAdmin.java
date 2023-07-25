package controller.admin;

import dao.AdminDAO;
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
import model.Admin;

@WebServlet(name = "ViewAdmin", urlPatterns = {"/ViewAdmin"})
public class ViewAdmin extends HttpServlet {

    private final AdminDAO adminDAO = new AdminDAO();
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "/ViewAdmin.jsp";

    protected void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String url = ERROR;

        try {
            String username = (String) session.getAttribute("PHONE_ADMIN");
            List<Admin> admin = adminDAO.getAdminByUsername(username);
            request.setAttribute("DETAILS_ADMIN", admin);

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
