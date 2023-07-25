/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.ConfirmPayDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.OrdersDAO;
import dao.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ConfirmPay;
import model.Customer;
import model.Employee;
import model.Order;
import model.Status;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ConfirmWork", urlPatterns = {"/ConfirmWork"})
public class ConfirmWork extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "EmployeeHome";
    private StatusDAO StatusDAO = new StatusDAO();
    private EmployeeDAO EmployeeDAO = new EmployeeDAO();
    private ConfirmPayDAO ConfirmPayDAO = new ConfirmPayDAO();
    private OrdersDAO OrderDAO = new OrdersDAO();
    private CustomerDAO CustomerDAO = new CustomerDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        try {
            //Update trang thái Hoàn thành (Status)
            int OrderID = Integer.parseInt(request.getParameter("OrderID"));
            Status Status = StatusDAO.getStatus(OrderID);
            StatusDAO.updateStatusFinished(Status);

            //Update trạng thái Employee (Status = 2)
            int EmployeeID = Status.getEmployee().getEmployeeID();
            Employee Employee = EmployeeDAO.getEmployeeByID(EmployeeID);
            EmployeeDAO.updateEmployeeStatus(Employee);

            Order Order = OrderDAO.details(OrderID);
            int CustomerID = Order.getCustomer().getCustomerID();
            Customer Customer = CustomerDAO.details(CustomerID);

            String ConfirmEmp = "Done";
            String ConfirmCus = null;
            String StatusPay = "Not Done";
            ConfirmPay Confirm = new ConfirmPay(ConfirmEmp, ConfirmCus, StatusPay, Status, Customer);
            ConfirmPayDAO.createConfirm(Confirm);

            url = SUCCESS;
        } catch (Exception ex) {
            log("Error at Confirm:" + ex.toString());
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
