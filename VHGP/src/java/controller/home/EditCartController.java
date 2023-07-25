///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller.home;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import tea.Cart;
//import tea.Tea;
//
///**
// *
// * @author Ngân
// */
//public class EditCartController extends HttpServlet {
//
//    private static final String ERROR = "error.jsp";
//    private static final String SUCCESS = "ViewCart.jsp";
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        String url = null;
//        try {
//            String id = request.getParameter("madv");
//            HttpSession session = request.getSession();
//            Cart cart = (Cart) session.getAttribute("CART");
//            String ids = request.getParameter("deliveryDate");
//            String deliveryDate = request.getParameter("deliveryDates");
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
//            Date dates = null;
//            try {
//                dates = dateFormat.parse(deliveryDate);
//                // Sử dụng biến date theo nhu cầu của bạn...
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            Tea tea = new Tea();
//            tea = cart.getCart().get(ids);
//            Tea newTea = new Tea(tea.getMadv(), tea.getTendv(), tea.getDongia(), tea.getDetails(), tea.getThoigian(), tea.getHinhanh(), tea.getDeliveryDate());
//            newTea.setDeliveryDate(dates);
//            tea.setDeliveryDate(dates);
//            cart.updatedate(dates, newTea);
//            
//            session.setAttribute("CART", cart);
//            boolean hasUpdatedData = true;
//            request.setAttribute("hasUpdatedData", hasUpdatedData);
//            url = SUCCESS;
//        } catch (Exception e) {
//            log("Error at EditCartController:" + e.toString());
//        } finally {
//            if (url != null) {
//                RequestDispatcher rd = request.getRequestDispatcher(url);
//                rd.forward(request, response);
//            }
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
