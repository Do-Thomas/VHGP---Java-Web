/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import MyUitl.MyUtil;
import controller.employee.UpdateEmployee;
import dao.CategoryDAO;
import dao.EmployeeDAO;
import dao.RoleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Employee;
import model.Role;
//

/**
 *
 * @author hathao
 */
@WebServlet(name = "UpdateEmployee", urlPatterns = {"/UpdateEmployee"})
public class UpdateEmployee extends HttpServlet {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();
    private final RoleDAO dao = new RoleDAO();
    private final CategoryDAO categoryDAOdao = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
            Employee item = employeeDAO.details(EmployeeID);
            request.setAttribute("item", item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdateEmployee.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int _EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
        String _EmployeeName = request.getParameter("EmployeeName");
        Date _BirthDay = Date.valueOf(request.getParameter("BirthDay"));
        String _EmployeePhone = request.getParameter("EmployeePhone");
        String _EmployeeAddress = request.getParameter("EmployeeAddress");
        String _EmployeePicture = request.getParameter("EmployeePicture");
        boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
        String _RoleID = request.getParameter("RoleID");
        String _CatName = request.getParameter("CatName");
        String _Password = request.getParameter("Password");
        int _Status = Integer.parseInt(request.getParameter("Status"));

        boolean hasError = false;
        Map<String, String> errorMap = new HashMap<>();

        if (!MyUtil.isValidLength(_EmployeeName) || !MyUtil.isValidInput(_EmployeeName)) {
            errorMap.put("_EmployeeName", "Vui lòng nhập EmployeeName có ít nhất 3 kí tự");
            hasError = true;
        }

        if (!MyUtil.isValidLength(_EmployeePhone) || !MyUtil.isValidInput(_EmployeePhone)) {
            errorMap.put("_EmployeePhone", "Vui lòng nhập EmployeePhone có 10 kí tự");
            hasError = true;
        }

        if (!MyUtil.isValidLength(_EmployeeAddress) || !MyUtil.isValidInput(_EmployeeAddress)) {
            errorMap.put(" _EmployeeAddress", "Vui lòng nhập EmployeeAddress");
            hasError = true;
        }

        if (!MyUtil.isValidLength(_Password) || !MyUtil.isValidInput(_Password)) {
            errorMap.put("_Password", "Vui lòng nhập Password có ít nhất 4 kí tự");
            hasError = true;
        }

//        if (!MyUtil.isValidLength(_BirthDay) || !MyUtil.isValidInput(_BirthDay)) {
//            errorMap.put("_BirthDay", "Vui lòng nhập BirthDay");
//            hasError = true;
//        }
//        
        RoleDAO roleDAO = new RoleDAO();
        Role _RoleIDEmp = roleDAO.details(_RoleID);

        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = categoryDAO.detailsByName(_CatName);

        try {
            Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay,
                    _EmployeePhone, _EmployeeAddress, _EmployeePicture, _EmployeeGender, _RoleIDEmp, category, _Password, _Status);

            if (hasError) {
                request.setAttribute("item", item);
                request.setAttribute("errorMap", errorMap);
                doGet(request, response); // Gọi lại doGet để tải lại trang và truyền dữ liệu qua request
                return;
            }
            employeeDAO.update(item);
            request.setAttribute("item", item);
            response.sendRedirect(request.getContextPath() + "/UpdateEmployee");
        } catch (NumberFormatException ex) {
            Logger.getLogger(UpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
