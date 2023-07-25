/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.CustomerContactDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/DeleteAddress"})
public class DeleteAddress extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String addressToDelete = request.getParameter("customerAddress");
            String phoneToDelete = request.getParameter("phone");
            CustomerContactDAO userContactDAO = new CustomerContactDAO();
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("LOGIN_USER");
            int CustomerID = customer.getCustomerID();
            userContactDAO.deleteCustomerContact(CustomerID, phoneToDelete, addressToDelete);
            response.sendRedirect("ViewCustomer");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
