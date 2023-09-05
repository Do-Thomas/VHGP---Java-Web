package controller.employee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.CategoryDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.RoleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Customer;
import model.Employee;
import model.Role;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "RegisterEmployee", urlPatterns = {"/RegisterEmployee"})
public class RegisterEmployee extends HttpServlet {

    private static final String ERROR = "/registerEmployee.jsp";
    private static final String SUCCESS = "/login.jsp";

    // Sử dụng Set để lưu trữ các giá trị đã nhập
    private Set<String> phoneSet;

    @Override
    public void init() throws ServletException {
        super.init();
        phoneSet = new HashSet<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/registerEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR;
        String empName = request.getParameter("EmployeeName");
        String birthDayString = request.getParameter("BirthDay");
        String empphone = request.getParameter("EmployeePhone");
        String catName = request.getParameter("CatName");
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = categoryDAO.detailsByName(catName);
        String empAddress = request.getParameter("EmployeeAddress");
        String empPicture = request.getParameter("EmployeePicture");
        Boolean genderString = Boolean.parseBoolean(request.getParameter("EmployeeGender"));
        String password = request.getParameter("Password");
        int status = 1;
        String confirm = request.getParameter("confirm");
        try {
//        String _RoleID = request.getParameter("RoleID");
            RoleDAO roleDAO = new RoleDAO();
            String roleID = "emp";
            Role role = roleDAO.details(roleID);

            boolean checkValidation = true;
            EmployeeDAO employeeDAO = new EmployeeDAO();
            Employee newEmployee = new Employee();

            if (empName.length() < 3) {
                newEmployee.setEmployeeName("Name must be more than 3 characters.");
                checkValidation = false;
            }

            if (password.length() < 2 || password.length() > 50) {
                newEmployee.setPassword("Password must be between 2 and 50 characters.");
                checkValidation = false;
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = (Date) formatter.parse(birthDayString);
                newEmployee.setBirthDay(date);
            } catch (ParseException e) {
                newEmployee.setBirthDay(date);
                checkValidation = false;
            }

            // Kiểm tra định dạng số điện thoại
//            Pattern phonePattern = Pattern.compile("^\\d{10}$"); // Định dạng 10 chữ số
//            if (!phonePattern.matcher(empphone).matches()) {
//                newEmployee.setEmployeePhone("Invalid phone number. Please enter a 10-digit phone number.");
//                checkValidation = false;
//                
//            }
            Pattern phonePattern = Pattern.compile("^0\\d{9}$"); // Định dạng số bắt đầu bằng 0 và có tổng cộng 10 chữ số
            if (!phonePattern.matcher(empphone).matches()) {
                newEmployee.setEmployeePhone("Invalid phone number. Please enter a 10-digit phone number starting with 0.");
                checkValidation = false;
            }

            Boolean gender = null;
            if (genderString != null) {
                gender = Boolean.valueOf(genderString);
            }

            // Kiểm tra trùng lặp số điện thoại và email
//            if (checkValidation == true) {
//                if (phoneSet.contains(empphone)) {
//                    newEmployee.setEmployeePhone("Phone number already exists.");
//                    checkValidation = false;
//                }
//            }
            if (checkValidation) {
                Employee emp = new Employee(empName, date, empphone, 
                        empAddress, empPicture, gender, roleID, category, password, status, confirm);
                boolean checkInsert = employeeDAO.insert(emp);
                if (checkInsert == false) {
                    url = SUCCESS;
                    phoneSet.add(empphone); // Lưu trữ số điện thoại đã nhập
                    // Lưu trữ email đã nhập
                }
            } else {
                request.setAttribute("EMP_ERROR", newEmployee);
            }
        } catch (Exception e) {
            log("Error at create: " + e.toString());
            if (e.toString().contains("duplicate")) {
                request.setAttribute("EMP_ERROR", "Duplicate employee name.");
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

}
