package controller.marketing;

import dao.MarketingDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import model.Marketing;
import model.Services;

@WebServlet(name = "UpdateMarketing", urlPatterns = {"/UpdateMarketing"})
public class UpdateMarketing extends HttpServlet {

    private final MarketingDAO marketingDAO = new MarketingDAO();
    private final ServicesDAO servicesDAO = new ServicesDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String Event = request.getParameter("Event");
            Marketing item = marketingDAO.detailsbyname(Event);

            request.setAttribute("item", item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateMarketing.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UpdateMarketing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String _Event = request.getParameter("Event");
        int _ServiceID = Integer.parseInt(request.getParameter("ServiceID"));
        Services ServiceID = servicesDAO.details(_ServiceID);
        String _StartTime = request.getParameter("StartTime");
        String _EndTime = request.getParameter("EndTime");
        int _Voucher = Integer.parseInt(request.getParameter("Voucher"));
        // Validate input data
        Map<String, String> errorMap = new HashMap<>();

        try {
//            RoleDAO roleDAO = new RoleDAO();
//            String roleId = "user";
//            Role role = roleDAO.details(roleId);

            boolean checkValidation = true;
            MarketingDAO marketingDAO = new MarketingDAO();
            Marketing newVoucher = new Marketing();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            Date datee = null;

            try {
                date = (Date) formatter.parse(_StartTime);
                newVoucher.setStartTime(date);
            } catch (ParseException e) {
                newVoucher.setStartTime("Invalid start time date format.");
                checkValidation = false;
            }

            try {
                datee = (Date) formatter.parse(_EndTime);
                newVoucher.setEndTime(datee);
            } catch (ParseException e) {
                newVoucher.setEndTime("Invalid start time date format.");
                checkValidation = false;
            }

            Marketing item = new Marketing(_Event, ServiceID, datee, datee, _Voucher);
            marketingDAO.update(item);
            response.sendRedirect(request.getContextPath() + "/ListOfMarketing");
        } catch (Exception ex) {
            Logger.getLogger(UpdateMarketing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
