/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.CustomerContactDAO;
import dao.CustomerDAO;
import dao.CustomerDetailsDAO;
import dao.OrdersDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.CustomerDetail;
import model.Customer_contact;
import model.Employee;
import model.Order;

/**
 *
 * @author Asus
 */
@WebServlet(name = "InsertOrderController", urlPatterns = {"/InsertOrderController"})
public class InsertOrderController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "CreateStatusOrder";
    private static final String MOMO = "qrcode.jsp";
    private final CustomerDAO dao = new CustomerDAO();
    private final ServicesDAO SDAO = new ServicesDAO();
    private final CustomerContactDAO CustomerContactDAO = new CustomerContactDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();
        try {
            Set<Integer> set = (Set<Integer>) session.getAttribute("MAP_ORDERID");
            Customer user = (Customer) session.getAttribute("LOGIN_USER");
            String OrderNote = request.getParameter("fRContent");
            if (set != null) {
                for (Integer id : set) {
                    int orderID = id;
                    OrdersDAO orderDAO = new OrdersDAO();
                    Order Order = orderDAO.details(orderID);
                    Order item = new Order(id, OrderNote);
                    orderDAO.updateOrderNote(item);

                    String Customer = user.getCustomerName();
                    String CustomerAddress = request.getParameter("Address");
                    String Phone = request.getParameter("Phone");

                    String Pay = request.getParameter("Pay");

                    CustomerDetailsDAO cDetailDAO = new CustomerDetailsDAO();
                    CustomerDetail customerD = new CustomerDetail(CustomerAddress, Phone, user, Order);
                    cDetailDAO.create(customerD);
                    url = SUCCESS;
                }
//               
            }
        } catch (Exception e) {
            log("Error at Payment:" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsertOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsertOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

//            //Tạo bảng Status
//            StatusDAO statusDAO = new StatusDAO();
//            Employee employee = (Employee) session.getAttribute("EMPLOYEE");
//            OrderDetail orderDetail = (OrderDetail) session.getAttribute("ORDER_DETAIL");
//            int orderID = orderDetail.getOrderID();
//            OrdersDAO orderDAO = new OrdersDAO();
//            Order Order = orderDAO.details(orderID);
//            String StatusName = "Hoạt động";
//            Date sqlDate = new Date(System.currentTimeMillis());
//
//            Status status = new Status(StatusName, sqlDate, Order, employee);
//
//            statusDAO.create(status);
