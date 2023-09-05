/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.CategoryDAO;
import dao.ReviewsDAO;
import dao.ServicesDAO;
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
import javax.servlet.http.HttpSession;
import model.Reviews;
import model.Services;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "DetailsService", urlPatterns = {"/DetailsService"})
public class DetailsService extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "details.jsp";
    private final ServicesDAO ServiceDAO = new ServicesDAO();
    private final CategoryDAO categoryDAO = new CategoryDAO();
    private final ReviewsDAO ReviewsDAO = new ReviewsDAO();
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            List<Services> listItem = ServiceDAO.read();
//            int _code = Integer.parseInt(request.getParameter("id"));
            String _name = request.getParameter("id");
            Services p = new Services();
            for (Services x : listItem) {
                if (x.getServiceName().equals(_name)) {
                    p = x;
                    List<Services> list = ServiceDAO.detailsby(p.getServiceName());
                    request.setAttribute("DETAILS_SERVICE", list);
                    request.setAttribute("img", p.getServicePicture());
                    
                }
            }
            int ServiceID = ServiceDAO.getFeedbackbyID(_name);
            List<Reviews> listFB = ReviewsDAO.getFeedBackService(ServiceID);
            request.setAttribute("LIST_FEEDBACK", listFB);
            url = SUCCESS;
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(DetailsService.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }

    }
}
