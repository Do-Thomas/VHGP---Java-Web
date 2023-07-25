package controller.home;

import dao.CustomerDAO;
import dao.RoleDAO;
import model.Customer;
import model.Role;

import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    private static final String ERROR = "/register.jsp";
    private static final String SUCCESS = "/login.jsp";

    // Sử dụng Set để lưu trữ các giá trị đã nhập
    private Set<String> phoneSet;
    private Set<String> emailSet;

    @Override
    public void init() throws ServletException {
        super.init();
        phoneSet = new HashSet<>();
        emailSet = new HashSet<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR;
        String customerName = request.getParameter("CustomerName");
        String phone = request.getParameter("Phone");
        String password = request.getParameter("Password");
        String birthDayString = request.getParameter("BirthDay");
        String email = request.getParameter("Email");
        String customerAddress = request.getParameter("CustomerAddress");
        Boolean genderString = Boolean.parseBoolean(request.getParameter("Gender"));
        String confirm = request.getParameter("confirm");

        try {
            RoleDAO roleDAO = new RoleDAO();
            String roleId = "user";
            Role role = roleDAO.details(roleId);

            boolean checkValidation = true;
            CustomerDAO customerDAO = new CustomerDAO();
            Customer newCustomer = new Customer();

            if (customerName.length() < 3) {
                newCustomer.setCustomerName("Name must be more than 3 characters.");
                checkValidation = false;
            }

            if (password.length() < 2 || password.length() > 50) {
                newCustomer.setPassword("Password must be between 2 and 50 characters.");
                checkValidation = false;
            }if (!confirm.equals(password)) {
                newCustomer.setConfirm("Passwords do not match.");
                checkValidation = false;
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = (Date) formatter.parse(birthDayString);
                newCustomer.setBirthDay(date);
            } catch (ParseException e) {
                newCustomer.setBirthDay("Invalid birth date format.");
                checkValidation = false;
            }

            // Kiểm tra định dạng số điện thoại
            Pattern phonePattern = Pattern.compile("^\\d{10}$"); // Định dạng 10 chữ số
            if (!phonePattern.matcher(phone).matches()) {
                newCustomer.setPhone("Invalid phone number. Please enter a 10-digit phone number.");
                checkValidation = false;
            }

            Boolean gender = null;
            if (genderString != null) {
                gender = Boolean.valueOf(genderString);
            }

            // Kiểm tra trùng lặp số điện thoại và email
            if (checkValidation == true) {
                if (phoneSet.contains(phone)) {
                    newCustomer.setPhone("Phone number already exists.");
                    checkValidation = false;
                }
                if (emailSet.contains(email)) {
                    newCustomer.setEmail("Email already exists.");
                    checkValidation = false;
                }
            }

            if (checkValidation == true) {
                Customer user = new Customer(customerName, phone, password, date, email, customerAddress, gender, role, confirm);
                boolean checkInsert = customerDAO.insert(user);
                if (checkInsert == false) {
                    url = SUCCESS;
                    phoneSet.add(phone); // Lưu trữ số điện thoại đã nhập
                    emailSet.add(email); // Lưu trữ email đã nhập
                }
            } else {
                request.setAttribute("USER_ERROR", newCustomer);
            }
        } catch (Exception e) {
            log("Error at create: " + e.toString());
            if (e.toString().contains("duplicate")) {
                request.setAttribute("USER_ERROR", "Duplicate customer name.");
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}