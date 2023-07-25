 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.CustomerDAO;
import dao.OrderDetailDAO;
import dao.OrdersDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Order;
import model.OrderDetail;
import model.Services;

/**
 *
 * @author Asus
 */
@WebServlet(name = "HistoryOrderController", urlPatterns = {"/HistoryOrderController"})
public class HistoryOrderController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "historyOrder.jsp";
    private static final CustomerDAO CustomerDAO = new CustomerDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String phone = (String) session.getAttribute("PHONE");
            Customer Customer = CustomerDAO.getAccountbyPhone(phone);
            OrdersDAO orderDAO = new OrdersDAO();
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            Order order = orderDAO.getListOrder(phone);
            int status = Integer.parseInt(request.getParameter("status"));
            int OrderID = order.getCustomer().getCustomerID();
            List<OrderDetail> listOrderDetail = new ArrayList<>();
            if (status == 1){
                String statusHoatDong = "Hoạt động";
                listOrderDetail = orderDetailDAO.getStatusOrder(statusHoatDong, OrderID);
            } else if (status == 2){
                String statusHoanThanh = "Hoàn thành";
                 listOrderDetail = orderDetailDAO.getStatusOrder(statusHoanThanh, OrderID);
            } else if (status == 3){
                String statusTamDung = "Tạm dừng";
                listOrderDetail = orderDetailDAO.getStatusOrder(statusTamDung, OrderID);
            } 
            
            int CustomerID = Customer.getCustomerID();
            int CountOrder = CustomerDAO.getCountOrder(CustomerID);
            double SumOrder = orderDAO.getSumOrder(CustomerID);
            
            ServicesDAO serviceDAO = new ServicesDAO();
            Services service = serviceDAO.details(OrderID);
            request.setAttribute("HISTORY_ORDER", listOrderDetail);
            request.setAttribute("COUNT_ORDER",CountOrder);
            request.setAttribute("SUM_ORDER",SumOrder);
            url = SUCCESS;
        } catch (Exception ex) {
            Logger.getLogger(InsertOrderController.class.getName()).log(Level.SEVERE, null, ex);
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
