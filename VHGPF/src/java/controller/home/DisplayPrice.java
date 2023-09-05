/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tea.Cart;
import tea.Tea;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "DisplayPrice", urlPatterns = {"/DisplayPrice"})
public class DisplayPrice extends HttpServlet {
private static final String ERROR="error.jsp";
    private static final String SUCCESS="ViewCart.jsp";
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
        String url =ERROR;
        try {
           String id = request.getParameter("madv");
 String ids = request.getParameter("tendv");

//            int newQuantity = Integer.parseInt(request.getParameter("soluong"));
            double newTime = Double.parseDouble(request.getParameter("thoigian"));
       String date = request.getParameter("deliveryDate");      
                   String time = request.getParameter("deliveryTime");
//            double newPrice = Double.parseDouble(request.getParameter("dongia"));
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            if(cart!=null){
                Tea tea= new Tea();
                if(cart.getCart().containsKey(time)){
                    
                    double newPrice;
                    tea = cart.getCart().get(time);
                    if(newTime==3){
                        newPrice=240;

                    }else{
                        newPrice=350;
                    }
//                    tea.setSoluong(newQuantity);
                    tea.setThoigian(newTime);
                    tea.setDongia(newPrice);
                    boolean result = cart.update(time, tea); 
                    
                    if (result == true) {
    request.setAttribute("cartDeleted", true);
}
                    
                    session.setAttribute("CART", cart);
                    url=SUCCESS;
                    
                }
            }
            
            
         
        
        } catch (Exception e) {
            log("Error at EditCartController:" +e.toString());
        }finally{
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
