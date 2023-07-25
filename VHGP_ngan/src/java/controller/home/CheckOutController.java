/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.CustomerContactDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.OrderDetailDAO;
import dao.OrdersDAO;
import dao.ServicesDAO;
import dao.StatusDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Employee;
import model.Order;
import model.OrderDetail;
import model.Services;
import tea.Cart;
import tea.Tea;

@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "checkOut.jsp";
    private static final String OUT = "OutOfStaff.jsp";
    private CustomerDAO customer = new CustomerDAO();
    private OrdersDAO orderDao = new OrdersDAO();
    private StatusDAO statusDao = new StatusDAO();
    private ServicesDAO serviceDAO = new ServicesDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            Set<Integer> set = new HashSet<Integer>();
            Set<Integer> setEmployee = new HashSet<Integer>();
            List<Services> listOfStaff = new ArrayList<>();
            List<OrderDetail> listOfOrderDetail = new ArrayList<>();
            Customer cus = (Customer) session.getAttribute("LOGIN_USER");
            int CustomerID = cus.getCustomerID();
            CustomerContactDAO customerContactDAO = new CustomerContactDAO();

            List<Customer> listaddress = customerContactDAO.getAddressPhoneList(CustomerID);
            request.setAttribute("Listaddress", listaddress);
            if (cart != null) {
                Map<String, Tea> items = cart.getCart();
//                Map<Timestamp, Timestamp> time = (Map<Timestamp, Timestamp>) session.getAttribute("TIME_END");
                if (items != null) {
//                    for (Map.Entry<Timestamp, Timestamp> timePass : time.entrySet()) {
                    for (Tea tea : items.values()) {
                        Date dateStart = tea.getDeliveryDate();//timeStart
                        Timestamp timeStartSQL = new Timestamp(dateStart.getTime());
                        Timestamp timeEndSQL = null;
                        if (tea.getThoigian() == 3) {
                            timeEndSQL = new Timestamp(dateStart.getTime() + TimeUnit.HOURS.toMillis(3));
                        } else {
                            timeEndSQL = new Timestamp(dateStart.getTime() + TimeUnit.HOURS.toMillis(4));
                        }

                        String id = tea.getMadv();
                        String phone = (String) session.getAttribute("PHONE_USER");
                        Customer customerID = customer.getAccountbyPhone(phone);
                        EmployeeDAO employeeDAO = new EmployeeDAO();
                        Employee employee = employeeDAO.getEmployeeByID(10000);
                        String OrderNote = request.getParameter("fRContent");
                        //Lấy từ CART(AddToCard)
                        //nhận price, devices, services từ AddToCard
                        int ServiceID = Integer.parseInt(id);
                        String OrderDServiceName = tea.getTendv();
                        Services service = serviceDAO.getServiceByID(ServiceID);
                        String OrderSName = service.getServiceName();
                        double OrderDServicePrice = service.getServicePrice();
                        int ServiceTime = service.getServiceTime();
                        //OrderDIDevices allow null(DB)
                        String OrderDIDevices = null;
                        String status = "Hoạt động";
                        String Pay = "COD";
                        if (employee != null) {
//                            int EmployeeID = employee.getEmployeeID();
//                            setEmployee.add(EmployeeID);
//                            session.setAttribute("EMPLOYEE", setEmployee);
                            Order order = new Order(OrderNote, customerID, employee);
                            orderDao.create(order);
//                            int StatusEmployee = employee1.getStatus();
//                            if (StatusEmployee != 1) {
//                                employeeDAO.updateEmployeeStatusWork(employee1);
//                            }
                            int OrderID = orderDao.getIDByLastOrder();
                            set.add(OrderID);
                            session.setAttribute("MAP_ORDERID", set);
                            OrderDetail orderItem
                                    = new OrderDetail(OrderID, ServiceID, OrderSName,
                                            OrderDServicePrice, OrderDIDevices, Pay, status,
                                            timeStartSQL, timeEndSQL, ServiceTime);
                            OrderDetailDAO orderDetail = new OrderDetailDAO();
                            orderDetail.insertOrderDetail(orderItem);
//                            session.setAttribute("ORDERID", OrderID);
                            listOfOrderDetail.add(orderItem);
                            request.setAttribute("CART_CHECKOUT", listOfOrderDetail);
                            url = SUCCESS;
//                        } else if (employee2 != null) {
//                            int EmployeeID = employee2.getEmployeeID();
//                            setEmployee.add(EmployeeID);
//                            session.setAttribute("EMPLOYEE", setEmployee);
//                            Order order = new Order(OrderNote, customerID, employee2);
//                            orderDao.create(order);
//                            int StatusEmployee = employee2.getStatus();
//                            if (StatusEmployee != 1) {
//                                employeeDAO.updateEmployeeStatusWork(employee2);
//                            }
//                            int OrderID = orderDao.getIDByLastOrder();
//                            set.add(OrderID);
//                            session.setAttribute("MAP_ORDERID", set);
//                            OrderDetail orderItem
//                                    = new OrderDetail(OrderID, ServiceID, OrderSName,
//                                            OrderDServicePrice, OrderDIDevices, Pay, status,
//                                            timeStartSQL, timeEndSQL, ServiceTime);
//                            OrderDetailDAO orderDetail = new OrderDetailDAO();
//                            orderDetail.insertOrderDetail(orderItem);
//                            session.setAttribute("ORDERID", OrderID);
//                            listOfOrderDetail.add(orderItem);
//                            request.setAttribute("CART_CHECKOUT", listOfOrderDetail);
//                            url = SUCCESS;
                        } else {
                            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
//                            Queue<Order> queue = new PriorityQueue<Order>();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S");
                            OrderDetail OrderDetail = orderDetailDAO.getDateLast();
                            String DateOfStaff = dateFormat.format(OrderDetail.getTimeEnd());
                            session.setAttribute("DATE_OF_STAFF", DateOfStaff);
                            listOfStaff.add(service);
                            request.setAttribute("SERVICE_OF_STAFF", listOfStaff);
                            url = OUT;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            log("Error at CheckOutController:" + ex.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
