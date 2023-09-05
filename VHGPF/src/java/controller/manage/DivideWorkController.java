/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manage;

import dao.EmployeeDAO;
import dao.OrderDetailDAO;
import dao.OrdersDAO;
import dao.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "DivideWorkController", urlPatterns = {"/DivideWorkController"})
public class DivideWorkController extends HttpServlet {

    private static final String SUCCESS = "ManageHome";
    private static final String ERROR = "login.jsp";
    private final StatusDAO StatusDAO = new StatusDAO();
    private final EmployeeDAO EmployeeDAO = new EmployeeDAO();
    private final OrdersDAO OrderDAO = new OrdersDAO();
    private final OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            int OrderID = Integer.parseInt(request.getParameter("OrderID"));
            String EmployeeName = request.getParameter("employee");
            if (EmployeeName == null) {
                request.setAttribute("error", "Không bỏ trống. Vui lòng nhập lại.");
                url = "ManageHome";
            } else{
                Employee Employee = EmployeeDAO.getEmployeeByName(EmployeeName);
                Order Order = new Order(OrderID, Employee);

                //Update Order - EmployeeID
                OrderDAO.updateOrder(Order);
                //Update Employee - Status  = 1
                EmployeeDAO.updateEmployeeStatusWork(Employee);
                //Update Status - EmployeeID
                Status UStatus = new Status(Order, Employee);
                StatusDAO.updateStatusEmployee(UStatus);
            }

//            OrderDetail OrderDetail = OrderDetailDAO.getOrderDetailbyID(OrderID);
//            String StringDateStart = request.getParameter("TimeStart");
//            if (StringDateStart.isEmpty()) {
//                url = SUCCESS;
//            } else {
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//                LocalDateTime localDateTime = LocalDateTime.parse(StringDateStart, formatter);
//                Timestamp TimeStart = Timestamp.valueOf(localDateTime);
//                int ServiceTime = Integer.parseInt(request.getParameter("ServiceTime"));
//                if (ServiceTime == 0){
//                    ServiceTime = OrderDetail.getServiceTime();
//                }
//                Timestamp TimeEnd = null;
//                if (ServiceTime == 3) {
//                    TimeEnd = new Timestamp(TimeStart.getTime() + TimeUnit.HOURS.toMillis(3));
//                } else if (ServiceTime == 4) {
//                    TimeEnd = new Timestamp(TimeStart.getTime() + TimeUnit.HOURS.toMillis(4));
//                }
//                OrderDetail UOrderDetail = new OrderDetail(OrderID, TimeStart, TimeEnd, ServiceTime);
//                OrderDetailDAO.updateOrderDetail(UOrderDetail);
//            }
            url = SUCCESS;
        } catch (Exception ex) {
            Logger.getLogger(ManageHome.class.getName()).log(Level.SEVERE, null, ex);
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
