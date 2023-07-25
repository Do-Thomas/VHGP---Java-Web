/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.ConfirmPayDAO;
import dao.CustomerDAO;
import dao.OrderDetailDAO;
import dao.OrdersDAO;
import dao.ReviewsDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ConfirmPay;
import model.Customer;
import model.Order;
import model.OrderDetail;
import model.Reviews;
import model.Services;

/**
 *
 * @author Asus
 */
@WebServlet(name = "IndexServices", urlPatterns = {"/IndexServices"})
public class IndexServices extends HttpServlet {

    private final ServicesDAO ServicesDAO = new ServicesDAO();
    private ReviewsDAO reviewsDAO = new ReviewsDAO();
    private static final ConfirmPayDAO ConfirmPayDAO = new ConfirmPayDAO();
    private static final CustomerDAO CustomerDAO = new CustomerDAO();
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "listOfServices.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String phone = (String) session.getAttribute("PHONE");
            OrdersDAO orderDAO = new OrdersDAO();
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            Order order = orderDAO.getListOrder(phone);
            int OrderID = order.getCustomer().getCustomerID();
            List<OrderDetail> combinedList = new ArrayList<>();
            List<OrderDetail> list = orderDetailDAO.getStatusOrders(OrderID);
            ServicesDAO serviceDAO = new ServicesDAO();
            Services service = serviceDAO.details(OrderID);
            request.setAttribute("NOTIFICATION", list);
            
            Customer Customer = CustomerDAO.getAccountbyPhone(phone);
            int CustomerID = Customer.getCustomerID();

            List<ConfirmPay> ConfirmPay = ConfirmPayDAO.getBillConfirm(CustomerID);
            request.setAttribute("CONFIRM", ConfirmPay);

            ServicesDAO dao = new ServicesDAO();
            List<Services> listServices = dao.getTopService();
            if (listServices.size() > 0) {
                request.setAttribute("TOP_SERVICES", listServices);
                List<Reviews> listFeedBack = reviewsDAO.getListFeedback();
                request.setAttribute("LIST_FEEDBACK", listFeedBack);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

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
