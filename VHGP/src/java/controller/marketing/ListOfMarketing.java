package controller.marketing;



import dao.MarketingDAO;
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
import model.Marketing;

/**
 *
 * @author hathao
 */
@WebServlet(name = "ListOfMarketing", urlPatterns = {"/ListOfMarketing"})
public class ListOfMarketing extends HttpServlet {

    private final MarketingDAO marketingDAO = new MarketingDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            List<Marketing> listItem = marketingDAO.read();
            request.setAttribute("LIST_MARKETING", listItem);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listOfMarketing.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListOfMarketing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Marketing> listItem = marketingDAO.read();
            request.setAttribute("LIST_MARKETING", listItem);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listOfMarketing.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListOfMarketing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
