/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.feedback;

import dao.CustomerDAO;
import dao.ReviewsDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Reviews;
import model.Services;

/**
 *
 * @author Asus
 */
@WebServlet(name = "FeedBack", urlPatterns = {"/FeedBack"})
public class FeedBack extends HttpServlet {

    private static final String ERROR = "errorPayemt.jsp";
    private static final String SUCCESS = "FinishedFeedBack.jsp";
    private CustomerDAO customer = new CustomerDAO();
    private ReviewsDAO reviewsDAO = new ReviewsDAO();
    private ServicesDAO serviceDAO = new ServicesDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String url = ERROR;
        try {
            String phone = (String) session.getAttribute("PHONE_USER");
            Customer customerID = customer.getAccountbyPhone(phone);
            int ServiceID = (int) session.getAttribute("SERVICES_HISTORY");
//            int ServiceID = Integer.parseInt(request.getParameter("ServiceID"));
            Services Services = serviceDAO.getServiceByID(ServiceID);
            String ReviewTitle = request.getParameter("title");

            Date date = new Date();
            java.sql.Date utilDate = new java.sql.Date(date.getTime());
            String Comment = request.getParameter("message");
            String Picture = request.getParameter("picture");
            int ReviewRating = Integer.parseInt(request.getParameter("rating"));

            Reviews item = new Reviews(ReviewTitle, utilDate, ReviewRating, Comment, Picture, Services, customerID);
            reviewsDAO.createFeedBack(item);
            String feedbackMessage = "Thank you for your feedback!";
            request.setAttribute("feedbackMessage", feedbackMessage);
            url = SUCCESS;
        } catch (Exception ex) {
            log("Error at Feedback:" + ex.toString());
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
