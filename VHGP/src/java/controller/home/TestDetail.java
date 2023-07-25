/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.CategoryDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
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
 * @author ADMIN
 */
@WebServlet(name = "TestDetail", urlPatterns = {"/TestDetail"})
public class TestDetail extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "TestList.jsp";
    private final ServicesDAO ServiceID = new ServicesDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            Map<String, Tea> items = cart.getCart();
            if (items != null) {
                Iterator<Map.Entry<String, Tea>> iterator = items.entrySet().iterator();
                Map.Entry<String, Tea> entry = iterator.next();
                while(iterator.hasNext())
                    iterator.remove();
                }

        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(DetailsService.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }

    }
}
