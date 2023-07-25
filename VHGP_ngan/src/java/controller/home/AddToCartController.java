/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tea.Cart;
import tea.Tea;

/**
 *
 * @author Ngân
 */
public class AddToCartController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ListAllServices";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String teaString = request.getParameter("cmbTea");
            String[] tmp = teaString.split("-");
            String madv = tmp[0];
            String tendv = tmp[1];
            double dongia = Double.parseDouble(tmp[2]);
            String details = tmp[3];
            double thoigian = Double.parseDouble(tmp[4]);
            String hinhanh = tmp[5];

Date currentDate = new Date();
        String outputFormat = "dd/M/yyyy HH:mm:ss";

        SimpleDateFormat outputFormatter = new SimpleDateFormat(outputFormat);
        String formattedDate = outputFormatter.format(currentDate);
        
        String inputFormat = "dd/M/yyyy HH:mm:ss";

        SimpleDateFormat inputFormatter = new SimpleDateFormat(inputFormat);
        Date date =null;
          Timestamp sqlTimestamp=null;
        try {
            date = inputFormatter.parse(formattedDate);
               sqlTimestamp = new Timestamp(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
// Lấy thời gian hiện tại
tmp[6] = sqlTimestamp.toString(); // Gán giá trị thời gian hiện tại vào tmp[6]

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
                cart = new Cart();
            }
                              
            Tea tea = new Tea(madv, tendv, dongia, details, thoigian, hinhanh,sqlTimestamp,sqlTimestamp);
            cart.add(tea);
//            session.setAttribute("delivery", tea);  
            session.setAttribute("CART", cart);
            request.setAttribute("MESSAGE", "Add successfully: " + tendv);
            url = SUCCESS;

        } catch (Exception e) {
            log("Error at AddToCartController: " + e.toString());
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
