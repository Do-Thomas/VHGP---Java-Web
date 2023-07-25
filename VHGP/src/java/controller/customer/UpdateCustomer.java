/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.customer;

import MyUitl.MyUtil;
import dao.CustomerDAO;
import dao.RoleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hathao
 */
@WebServlet(name = "UpdateCustomer", urlPatterns = {"/UpdateCustomer"})
public class UpdateCustomer extends HttpServlet {
    
    private final CustomerDAO customerDAO = new CustomerDAO();
    private final RoleDAO dao = new RoleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           int CustomerID = Integer. parseInt (request.getParameter("CustomerID"));
//            String _CustomerName = request.getParameter("CustomerName");
            Customer item = customerDAO. details(CustomerID);
            request.setAttribute("item", item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdateCustomer.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

                int _ID = Integer.parseInt(request.getParameter("CustomerID"));
                String _CustomerName = request.getParameter("CustomerName");
                String _Phone = request.getParameter("Phone");
                String _Password = request.getParameter("Password");
                Date _BirthDay = Date.valueOf(request.getParameter("BirthDay"));
                String _Email = request.getParameter("Email");
                String _CustomerAddress = request.getParameter("CustomerAddress");
                Boolean _Gender = Boolean.parseBoolean(request.getParameter("Gender"));
//                String _RoleID = request.getParameter("RoleID");
              

        boolean hasError = false;
        Map<String, String> errorMap = new HashMap<>();

        if (!MyUtil.isValidLength(_CustomerName) || !MyUtil.isValidInput(_CustomerName)) {
            errorMap.put("_CustomerName", "Vui lòng nhập CustomerName có ít nhất 3 kí tự");
            hasError = true;
        }

        if (!MyUtil.isValidLength(_Phone) || !MyUtil.isValidInput(_Phone)) {
            errorMap.put("_Phone", "Vui lòng nhập Phone có 10 số");
            hasError = true;
        }

        if (!MyUtil.isValidLength(_Password) || !MyUtil.isValidInput(_Password)) {
            errorMap.put("_Password", "Vui lòng nhập Password có ít nhất 5 kí tự");
            hasError = true;
        }

        if (!MyUtil.isValidLength(_Email) || !MyUtil.isValidInput(_Email)) {
            errorMap.put("_Email", "Vui lòng nhập Email có ít nhất 3 kí tự");
            hasError = true;
        }

        if (!MyUtil.isValidLength(_CustomerAddress) || !MyUtil.isValidInput(_CustomerAddress)) {
            errorMap.put("_CustomerAddress", "Vui lòng nhập CustomerAddress");
            hasError = true;
        }
        
//        RoleDAO roleDAO = new RoleDAO();
//        Role _RoleIDCustomer = dao.details(_RoleID);

        try {
            Customer item = new Customer(_ID, _CustomerName, _Phone, _Password, 
                        _BirthDay, _Email, _CustomerAddress, _Gender);
            if (hasError) {
                request.setAttribute("item", item);
                request.setAttribute("errorMap", errorMap);
                doGet(request, response); // Gọi lại doGet để tải lại trang và truyền dữ liệu qua request
                return;
            }
            customerDAO. update(item);
            request.setAttribute("item", item);
            response.sendRedirect(request.getContextPath() + "/ViewCustomer");
        } catch (NumberFormatException ex) {
            Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
