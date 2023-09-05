package controller.category;

import dao.CategoryDAO;
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

@WebServlet(name = "CreateCategory", urlPatterns = {"/CreateCategory"})
public class CreateCategory extends HttpServlet {

    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/CreateCategory.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

     
        String _CatName = request.getParameter("CatName");
        String _CatStatus = request.getParameter("CatStatus");
        String _CatPicture = request.getParameter("CatPicture");

        // Validate input data
        Map<String, String> errorMap = new HashMap<>();

        if (_CatName == null || _CatName.trim().isEmpty()) {
            errorMap.put("CatName", "CatName is required.");
        }

        if (!errorMap.isEmpty()) {
            // Set errorMap as request attribute and forward back to the form
            request.setAttribute("errorMap", errorMap);
            doGet(request, response); // Forward to doGet to display the form with errors
            return;
        }

        try {
            Category item = new Category(0, _CatName, _CatStatus, _CatPicture);
            categoryDAO.create(item);
            response.sendRedirect(request.getContextPath() + "/ListOfCategory");
        } catch (Exception ex) {
            Logger.getLogger(CreateCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
