/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.CustomerContactDAO;
import dao.CustomerDAO;
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
import model.Customer;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AddressMore", urlPatterns = {"/AddressMore"})
public class AddressMore extends HttpServlet {

    private CustomerContactDAO customerContactDAO = new CustomerContactDAO();
    private final CustomerDAO CustomerDAO = new CustomerDAO();
//    CustomerContactDAO customerContactDAO = new CustomerContactDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("LOGIN_USER");
        if (customer != null) {
            String Area = request.getParameter("area");
            String Building = request.getParameter("building");
            String Floor = request.getParameter("floor");
            String Room = request.getParameter("room");
            
            String Phone = request.getParameter("Phone");
            if (Phone.isEmpty()){
                Phone = customer.getPhone();
            }
            String CustomerAddress = Area.concat(Building).concat(", ").concat(Floor).concat(Room);
            if (!isValidPhoneNumber(Phone)) {
                request.setAttribute("error", "Số điện thoại không hợp lệ. Vui lòng nhập lại.");
                request.setAttribute("phone", Phone);
                request.getRequestDispatcher("addmoreaddress.jsp").forward(request, response);
            } else {
                try {
                    if (customerContactDAO.checkDuplicateAddress(CustomerAddress) == false) {
                        request.setAttribute("error", "Số nhà đã tồn tại ở tài khoản khác");
                        request.setAttribute("phone", Phone);
                        request.setAttribute("CustomerAddress", CustomerAddress);
                        request.getRequestDispatcher("addmoreaddress.jsp").forward(request, response);
                    } else {
                        customer.setCustomerAddress(CustomerAddress);
                        customer.setPhone(Phone);
                        customerContactDAO.addCustomerContact(customer);
                        response.sendRedirect("ViewCustomer");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Đã xảy ra lỗi. Vui lòng thử lại sau.");
                    request.getRequestDispatcher("addmoreaddress.jsp").forward(request, response);
                }
            }

        } else {
            response.sendRedirect("login.jsp");
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            return false;
        }
        if (!phoneNumber.startsWith("0")) {
            return false;
        }
        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
