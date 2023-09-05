package controller.admin;

import MyUitl.MyUtil;
import dao.CategoryDAO;
import dao.ServicesDAO;
import java.io.IOException;
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
import model.Services;

@WebServlet(name = "CreateServices", urlPatterns = {"/CreateServices"})
public class CreateServices extends HttpServlet {

    private final ServicesDAO servicesDAO = new ServicesDAO();
    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/createService.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String _ServiceName = request.getParameter("ServiceName");
        String _ServiceDetail = request.getParameter("ServiceDetail");
        String _ServiceTimeStr = request.getParameter("ServiceTime");
        String _ServicePriceStr = request.getParameter("ServicePrice");
        String _ServicePicture = request.getParameter("ServicePicture");
        String _CatID = request.getParameter("CatID");

        // Validate input data
        Map<String, String> errorMap = new HashMap<>();

        if (_ServiceName == null || _ServiceName.trim().isEmpty()) {
            errorMap.put("ServiceName", "Service Name is required.");
        } else if (!MyUtil.isValidLength(_ServiceName) || !MyUtil.isValidInput(_ServiceName)) {
            errorMap.put("ServiceName", "Please enter a Service Name with at least 3 characters.");
        }
        if (_ServiceDetail == null || _ServiceDetail.trim().isEmpty()) {
            errorMap.put("ServiceDetail", "Service Detail is required.");
        } else if (!MyUtil.isValidLength(_ServiceDetail) || !MyUtil.isValidInput(_ServiceDetail)) {
            errorMap.put("ServiceDetail", "Please enter a Service Detail with at least 3 characters.");
        }
        if (_ServiceTimeStr == null || _ServiceTimeStr.trim().isEmpty()) {
            errorMap.put("ServiceTime", "Service Time is required.");
        } else {
            try {
                int _ServiceTime = Integer.parseInt(_ServiceTimeStr);
                // Kiểm tra giá trị đầu vào của ServiceTime
                if (_ServiceTime != 3 && _ServiceTime != 4) {
                    errorMap.put("ServiceTime", "Invalid Service Time value. Service Time must be 3 or 4.");
                }
            } catch (NumberFormatException e) {
                errorMap.put("ServiceTime", "Invalid Service Time, please enter a number.");
            }
        }
        if (_ServicePriceStr == null || _ServicePriceStr.trim().isEmpty()) {
            errorMap.put("ServicePrice", "Service Price is required.");
        } else {
            try {
                double _ServicePrice = Double.parseDouble(_ServicePriceStr);
                // Kiểm tra giá trị đầu vào của ServicePrice
                if (_ServicePrice != 240 && _ServicePrice != 350) {
                    errorMap.put("ServicePrice", "Invalid Service Price value. Service Price must be 240 or 350.");
                }
            } catch (NumberFormatException e) {
                errorMap.put("ServicePrice", "Invalid Service Price, please enter a number.");
            }
        }
        if (_CatID == null || _CatID.trim().isEmpty()) {
            errorMap.put("CatID", "Cat ID is required.");
        } else {
            // Check if CatID exists
            int catID = Integer.parseInt(_CatID);
            Category cat = categoryDAO.details(catID);
            if (cat == null) {
                errorMap.put("CatID", "Invalid Cat ID.");
            }
        }

        if (!errorMap.isEmpty()) {
            // Set errorMap as request attribute and forward back to the form
            request.setAttribute("errorMap", errorMap);
            doGet(request, response); // Forward to doGet to display the form with errors
            return;
        }

        int catID = Integer.parseInt(_CatID);
        Category cat = categoryDAO.details(catID);
        if (cat == null) {
            errorMap.put("CatID", "Invalid Cat ID.");
            request.setAttribute("errorMap", errorMap);
            doGet(request, response);
            return;
        }

        try {
            Services service = new Services(0 , _ServiceName, _ServiceDetail, Integer.parseInt(_ServiceTimeStr),
                    Double.parseDouble(_ServicePriceStr), _ServicePicture, cat);
            String generatedID = servicesDAO.createAndGetID(service);
            service.setServiceID(generatedID);
            servicesDAO.update(service);
            response.sendRedirect(request.getContextPath() + "/admin");
        } catch (Exception ex) {
            Logger.getLogger(CreateServices.class.getName()).log(Level.SEVERE, null, ex);
            // Handle exception, e.g., display an error message
            // You can redirect to an error page or display a message on the same page
        }
    }
}
