/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.category;

import dao.ServicesDAO;
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
import model.Services;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ShowServicesDondepCategory", urlPatterns = {"/ShowServicesDondepCategory"})
public class ShowServicesDondepCategory extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "/admin/showServicesDondepCategory.jsp";

    private final ServicesDAO code = new ServicesDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int _code = Integer.parseInt(request.getParameter("id"));
            List<Services> listItem = code.detailServices(_code);

            request.setAttribute("SHOW_CAT", listItem);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/showServicesDondepCategory.jsp");
            rd.forward(request, response);
            url = SUCCESS;
        } catch (IOException | ServletException ex) {
            Logger.getLogger(ShowServicesDondepCategory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
