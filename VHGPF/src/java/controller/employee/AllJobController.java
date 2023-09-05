/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.EmployeeDAO;
import dao.OrderDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Employee;
import model.OrderDetail;
/**
 *
 * @author Asus
 */
@WebServlet(name = "AllJobController", urlPatterns = {"/AllJobController"})
public class AllJobController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "AllJob.jsp";
    private OrderDetailDAO odDAO = new OrderDetailDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Employee employee = (Employee) session.getAttribute("EMPLOYEE");
            int EmployeeID = employee.getEmployeeID();
            
            // Lấy danh sách công việc của nhân viên từ DAO
            List<OrderDetail> listEmployee = odDAO.getListJob(EmployeeID);
            
            // Sắp xếp danh sách listEmployee dựa trên thời gian bắt đầu của các sự kiện
            Collections.sort(listEmployee, new Comparator<OrderDetail>() {
                @Override
                public int compare(OrderDetail o1, OrderDetail o2) {
                    return o1.getTimeStart().compareTo(o2.getTimeStart());
                }
            });

            // Đặt danh sách đã sắp xếp vào thuộc tính request để truyền đến JSP
            request.setAttribute("LIST_JOB", listEmployee);
            
            url = SUCCESS;
        } catch (Exception ex) {
            log("Error at AllJobController:" + ex.toString());
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
