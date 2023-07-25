/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.EmployeeDAO;
import dao.OrdersDAO;
import dao.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Employee;
import model.Order;
import model.Status;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ShowBillController", urlPatterns = {"/ShowBillController"})
public class ShowBillController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ShowBill.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String url = ERROR;
        List<Order> listBill = new ArrayList<>();
        try {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            StatusDAO statusDAO = new StatusDAO();
            //Tạo bảng Status
            Set<Integer> set = (Set<Integer>) session.getAttribute("MAP_ORDERID");
            if (set != null) {
                for (Integer OrderID : set) {
                    int orderID = OrderID;
                    OrdersDAO orderDAO = new OrdersDAO();
                    Order Order = orderDAO.getBill(orderID);
                    listBill.add(Order);
                    request.setAttribute("INFO", Order);
                }
                
                request.setAttribute("BILL", listBill);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at Payment:" + e.toString());
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
