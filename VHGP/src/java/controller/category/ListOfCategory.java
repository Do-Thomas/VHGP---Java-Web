package controller.category;

import dao.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ListOfCategory", urlPatterns = {"/ListOfCategory"})
public class ListOfCategory extends HttpServlet {

    private final CategoryDAO categoryDAO = new CategoryDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            List<Category> listItem = categoryDAO.read();
            request.setAttribute("LIST_CATEGORY", listItem);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listOfCategory.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListOfCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Category> listItem = categoryDAO.read();
            request.setAttribute("LIST_CATEGORY", listItem);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listOfCategory.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListOfCategory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
