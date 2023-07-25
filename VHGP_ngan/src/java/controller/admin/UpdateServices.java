package controller.admin;

import MyUitl.MyUtil;
import dao.CategoryDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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

@WebServlet(name = "UpdateServices", urlPatterns = {"/UpdateServices"})
public class UpdateServices extends HttpServlet {

    private final ServicesDAO servicesDAO = new ServicesDAO();
    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String id = request.getParameter("Id");
            Services item = servicesDAO.detailsbyid(id);

            request.setAttribute("item", item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateServices.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UpdateServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        int _ServiceID = Integer.parseInt(request.getParameter("ServiceID"));
        String _ServiceName = new String(request.getParameter("ServiceName").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String _ServiceDetail = new String(request.getParameter("ServiceDetail").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        int _ServiceTime = Integer.parseInt(request.getParameter("ServiceTime"));
        double _ServicePrice = Double.parseDouble(request.getParameter("ServicePrice"));
        String _ServicePicture = request.getParameter("ServicePicture");
        String _CatIDStr = request.getParameter("CatID");

        boolean hasError = false;
        Map<String, String> errorMap = new HashMap<>();

        if (!MyUtil.isValidLength(_ServiceName) || !MyUtil.isValidInput(_ServiceName)) {
            errorMap.put("ServiceName", "Vui lòng nhập tên dịch vụ có ít nhất 3 kí tự");
            hasError = true;
        }

        if (!MyUtil.isValidLength(_ServiceDetail) || !MyUtil.isValidInput(_ServiceDetail)) {
            errorMap.put("ServiceDetail", "Vui lòng nhập chi tiết dịch vụ có ít nhất 3 kí tự");
            hasError = true;
        }

        if (_CatIDStr == null || _CatIDStr.trim().isEmpty()) {
            errorMap.put("CatID", "Vui lòng chọn ID danh mục");
            hasError = true;
        }

        if (hasError) {
            // Xử lý khi có lỗi
            Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, null);
            request.setAttribute("item", item);
            request.setAttribute("errorMap", errorMap);
            doGet(request, response); // Gọi lại doGet để tải lại trang và truyền dữ liệu qua request
        } else {
            // Tiến hành cập nhật dữ liệu
            int _CatID = Integer.parseInt(_CatIDStr);
            Category category = categoryDAO.details(_CatID);
            try {
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, category);
                servicesDAO.update(item);
                response.sendRedirect(request.getContextPath() + "/admin");
            } catch (Exception ex) {
                Logger.getLogger(UpdateServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}