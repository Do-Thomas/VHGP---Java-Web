/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
@WebServlet(name = "search", urlPatterns = {"/search"})
public class search extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //        if (request.getSession().getAttribute(name))

        try {
            ServicesDAO daoServices = new ServicesDAO();
            String searchName = request.getParameter("searchName");
            Services listServices = new Services();
            ArrayList<Services> searchResult = (ArrayList<Services>) daoServices.searchByName(searchName);
            for (Services Services : searchResult) {
                listServices = Services;
            }
            request.setAttribute("SEARCH_RESULT", searchResult);
            request.setAttribute("listServices", listServices);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/search.jsp");
            rd.forward(request, response);
            //  response.sendRedirect("../view/home/search.jsp");
        } catch (Exception e) {
        }
    }
}
