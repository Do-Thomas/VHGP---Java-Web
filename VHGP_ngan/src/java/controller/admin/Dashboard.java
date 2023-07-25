/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dao.CustomerDAO;
import dao.OrderDetailDAO;
import dao.OrdersDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Order;
import model.Services;

/**
 *
 * @author ngodi
 */
@WebServlet(name = "Dashboard", urlPatterns = {"/Dashboard"})
public class Dashboard extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            model.Customer customer = (Customer) session.getAttribute("LOGIN_USER");
            CustomerDAO dao = new CustomerDAO();
            List<Customer> customer1 = dao.getCustomer();
            ServicesDAO p = new ServicesDAO();
            List<Services> services = p.read();
            OrdersDAO b = new OrdersDAO();
            List<Order> bill = b.getBill();
            OrderDetailDAO m = new OrderDetailDAO();
            for (int i = 1; i <= 12; i++) {
                System.out.println(m.moneymonth(i));
            }

            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH) + 1;

            request.setAttribute("tien1", m.moneymonth(1));
            request.setAttribute("tien2", m.moneymonth(2));
            request.setAttribute("tien3", m.moneymonth(3));
            request.setAttribute("tien4", m.moneymonth(4));
            request.setAttribute("tien5", m.moneymonth(5));
            request.setAttribute("tien6", m.moneymonth(6));
            request.setAttribute("tien7", m.moneymonth(7));
            request.setAttribute("sizecustomer", customer1.size());
            request.setAttribute("sizeser", services.size());
            request.setAttribute("sizebill", bill.size());
            request.setAttribute("moneymonth", m.moneymonth(month));
            // Lấy ngày hiện tại
//            String targetDate = request.getParameter("targetDate");
//
//// Kiểm tra xem targetDate có tồn tại hay không
//            if (targetDate == null) {
//                // Nếu không có ngày cụ thể, mặc định lấy ngày hiện tại
//                LocalDate currentDate = LocalDate.now();
//                targetDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//            }
//
//// Lấy doanh thu theo ngày
//            int dailyStat = m.moneyStat(targetDate);
//            int totalRevenue = dailyStat; // Gán totalRevenue bằng dailyStat
//
//            request.setAttribute("sizecustomer", customer1.size());
//            request.setAttribute("sizeser", services.size());
//            request.setAttribute("sizebill", bill.size());
//            request.setAttribute("dailyStat", dailyStat);
//            request.setAttribute("totalRevenue", totalRevenue); // Thêm totalRevenue vào thuộc tính của yêu cầu
//            request.setAttribute("targetDate", targetDate);
//
//            request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");

// Kiểm tra xem startDate và endDate có tồn tại hay không
            if (startDate == null || endDate == null) {
                // Nếu không có ngày cụ thể, mặc định lấy ngày hiện tại
                LocalDate currentDate = LocalDate.now();
                startDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                endDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

// Lấy doanh thu trong khoảng thời gian từ startDate đến endDate
            int revenueInRange = m.moneyStatRange(startDate, endDate);
            int totalRevenue = revenueInRange;
            request.setAttribute("sizecustomer", customer1.size());
            request.setAttribute("sizeser", services.size());
            request.setAttribute("sizebill", bill.size());
            request.setAttribute("dailyStat", 0); // Khởi tạo dailyStat với giá trị 0
            request.setAttribute("totalRevenue", revenueInRange); // Thêm totalRevenue vào thuộc tính của yêu cầu
            request.setAttribute("targetDate", ""); // Không cần sử dụng targetDate nữa

            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);

            request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("404.jsp");
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
