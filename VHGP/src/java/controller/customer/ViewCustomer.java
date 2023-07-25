/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.customer;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.runtime.Debug.id;
import model.Customer;

/**
 *
 * @author hathao
 */
@WebServlet(name = "ViewCustomer", urlPatterns = {"/ViewCustomer"})
public class ViewCustomer extends HttpServlet {
    
    private final CustomerDAO customerDAO = new CustomerDAO();
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "/ViewCustomer.jsp";


    protected void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String url = ERROR;

        try {
            String Phone = (String) session.getAttribute("PHONE_USER"); 
            Customer cus = (Customer) customerDAO.getCustomerbyPhone(Phone);
            List<Customer> list = new ArrayList<>();
            list.add(cus);
            request.setAttribute("DETAILS_CUSTOMER", list);

            url = SUCCESS;
        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }
}
