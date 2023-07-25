/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Services;

/**
 *
 * @author ADMIN
 */
public class CancelServices extends HttpServlet {

    private final ServicesDAO servicesDAO = new ServicesDAO();
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ListOfServicesAdmin";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            String ServiceStatus = request.getParameter("ServiceStatus");
            Services item = servicesDAO.getServiceStatus(ID);
            if (ServiceStatus.equals("Hoạt động")) {
                servicesDAO.updateService(item);
                request.setAttribute("item", item);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin");
                rd.forward(request, response);
            } else {
                servicesDAO.updateStatusHoatDong(item);
                request.setAttribute("item", item);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin");
                rd.forward(request, response);
            }

        } catch (Exception ex) {
            Logger.getLogger(CancelServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//
//        int ServiceID = Integer.parseInt(request.getParameter("ServiceID"));
//        String ServiceStatus = request.getParameter("ServiceStatus");
//        try {
//            Services item = new Services(ServiceID, ServiceStatus);
//            servicesDAO.updateService(item);
//            response.sendRedirect(request.getContextPath() + "/admin");
//        } catch (Exception ex) {
//            Logger.getLogger(CancelServices.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
