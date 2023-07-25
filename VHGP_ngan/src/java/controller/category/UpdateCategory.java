package controller.category;

import MyUitl.MyUtil;
import dao.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import static java.nio.charset.StandardCharsets.UTF_8;
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

/**
 *
 * @author hathao
 */
@WebServlet(name = "UpdateCategory", urlPatterns = {"/UpdateCategory"})
public class UpdateCategory extends HttpServlet {

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
            Category item = categoryDAO.detailsbyid(id);
            request.setAttribute("item", item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdateCategory.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UpdateCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        int _CatID = Integer.parseInt(request.getParameter("CatID"));
        String _CatName = new String(request.getParameter("CatName").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String _CatStatus =new String(request.getParameter("CatStatus").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String _CatPicture = request.getParameter("CatPicture");

        boolean hasError = false;
        Map<String, String> errorMap = new HashMap<>();

        if (!MyUtil.isValidLength(_CatName) || !MyUtil.isValidInput(_CatName)) {
            errorMap.put("CatName", "Vui lòng nhập CatName có ít nhất 3 kí tự");
            hasError = true;
        }

        if (!MyUtil.isValidLength(_CatStatus) || !MyUtil.isValidInput(_CatStatus)) {
            errorMap.put("CatStatus", "Vui lòng nhập CatStatus có ít nhất 3 kí tự");
            hasError = true;
        }

        try {
            Category item = new Category(_CatID, _CatName, _CatStatus, _CatPicture);

            if (hasError) {
                request.setAttribute("item", item);
                request.setAttribute("errorMap", errorMap);
                doGet(request, response); // Gọi lại doGet để tải lại trang và truyền dữ liệu qua request
                return;
            }

            categoryDAO.update(item);
            request.setAttribute("item", item);
            response.sendRedirect(request.getContextPath() + "/ListOfCategory");
        } catch (Exception ex) {
            Logger.getLogger(UpdateCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
