/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.confirm;

import dao.EmployeeDAO;
import dao.OrderDetailDAO;
import dao.OrdersDAO;
import dao.StatusDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Status;

/**
 *
 * @author Asus
 */
@WebServlet(name = "CancelOrderCustomer", urlPatterns = {"/CancelOrderCustomer"})
public class CancelOrderCustomer extends HttpServlet {

    private final StatusDAO StatusDAO = new StatusDAO();
    private final OrdersDAO OrderDAO = new OrdersDAO();
    private final OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
    private final EmployeeDAO EmployeeDAO = new EmployeeDAO();
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "MainController?action=History&status=1";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int OrderID = Integer.parseInt(request.getParameter("OrderID"));
//            OrderDetailDAO.deleteOrderDetail(OrderID); //OrderDetail - Delete
//            OrderDAO.deleteOrder(OrderID); // Order - Delete 

            Status Status = StatusDAO.getStatus(OrderID);
            StatusDAO.updateStatusCancel(Status); // Status - StatusName - Hủy

            url = SUCCESS;
        } catch (Exception ex) {
            Logger.getLogger(CancelOrderCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
