package controller.marketing;



import MyUitl.MyUtil;
import dao.CategoryDAO;
import dao.CustomerDAO;
import dao.MarketingDAO;
import dao.RoleDAO;
import dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
import model.Role;
import model.Services;

/**
 * Servlet implementation class CreateMarketing
 */
@WebServlet(name = "CreateMarketing", urlPatterns = {"/CreateMarketing"})
public class CreateMarketing extends HttpServlet {

    private final MarketingDAO MarketingDAO = new MarketingDAO();
    private final ServicesDAO servicesDAO = new ServicesDAO();
    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/createMarketing.jsp");
        rd.forward(request, response);
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
        Timestamp timestamp1 = null;
        Timestamp timestamp = null;
//                try {
//                    date = (java.util.Date) formatter.parse(_StartTime);
//                                java.sql.Date sqlDate1 = new java.sql.Date(date.getTime());
//             timestamp1 = new Timestamp(sqlDate1.getTime());
//                    newVoucher.setStartTime(timestamp1);
        try {
//            RoleDAO roleDAO = new RoleDAO();
//            String roleId = "user";
//            Role role = roleDAO.details(roleId);

            boolean checkValidation = true;
            MarketingDAO marketingDAO = new MarketingDAO();
            Marketing newVoucher = new Marketing();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            Date date = null;
            Date datee = null;

            try {

                date = (java.util.Date) formatter.parse(_StartTime);
                java.sql.Date sqlDate1 = new java.sql.Date(date.getTime());
                timestamp1 = new Timestamp(sqlDate1.getTime());
                newVoucher.setStartTime(timestamp1);
            } catch (ParseException e) {
                newVoucher.setStartTime("Invalid start time date format.");
                checkValidation = false;
            }

            try {
                datee = (java.util.Date) formatter.parse(_EndTime);
                java.sql.Date sqlDate2 = new java.sql.Date(datee.getTime());
                timestamp = new Timestamp(sqlDate2.getTime());
                newVoucher.setStartTime(timestamp);
            } catch (ParseException e) {
                newVoucher.setEndTime("Invalid end time date format.");
                checkValidation = false;
            }

            Marketing item = new Marketing(_Event, ServiceID, timestamp1, timestamp, _Voucher);
            MarketingDAO.create(item);

//            String generatedID = servicesDAO.createAndGetID(service);
//            service.setServiceID(generatedID);
//            MarketingDAO.update(marketing);
            response.sendRedirect(request.getContextPath() + "/ListOfMarketing");
        } catch (Exception ex) {
            Logger.getLogger(CreateMarketing.class.getName()).log(Level.SEVERE, null, ex);
            // Handle exception, e.g., display an error message
            // You can redirect to an error page or display a message on the same page
        }
    }
}
