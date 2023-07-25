/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.confirm;

import dao.ConfirmPayDAO;
import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ConfirmPay;
import model.Customer;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ConfirmBillCustomerController", urlPatterns = {"/ConfirmBillCustomerController"})
public class ConfirmBillCustomerController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ConfirmBillCustomer.jsp";
    private static final ConfirmPayDAO ConfirmPayDAO = new ConfirmPayDAO();
    private static final CustomerDAO CustomerDAO = new CustomerDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String phone = (String) session.getAttribute("PHONE");
            Customer Customer = CustomerDAO.getAccountbyPhone(phone);
            int CustomerID = Customer.getCustomerID();
                    
            List<ConfirmPay> ConfirmPay = ConfirmPayDAO.getBillConfirm(CustomerID);
            request.setAttribute("BILL_CONFIRM", ConfirmPay);
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at ConfirmBillCustomer:" + e.toString());
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
