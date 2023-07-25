///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller.home;
//
//import dao.CustomerDAO;
//import dao.EmployeeDAO;
//import dao.OrderDetailDAO;
//import dao.OrdersDAO;
//import dao.ServicesDAO;
//import dao.StatusDAO;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import model.Customer;
//import model.Employee;
//import model.Order;
//import model.OrderDetail;
//import model.Services;
//import model.Status;
//import tea.Cart;
//import tea.Tea;
//
///**
// *
// * @author Asus
// */
//@WebServlet(name = "TestOrder", urlPatterns = {"/TestOrder"})
//public class TestOrder extends HttpServlet {
//
//    private static final String ERROR = "errorPayment.jsp";
//    private static final String SUCCESS = "listOfServices.jsp";
//
//    private CustomerDAO customer = new CustomerDAO();
//    private OrdersDAO orderDao = new OrdersDAO();
//    private StatusDAO statusDao = new StatusDAO();
//    private ServicesDAO serviceDAO = new ServicesDAO();
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        String url = ERROR;
////        int OrderID = 3;
////        String OrderDServiceName = "Vệ sinh máy lạnh";
////        double price = 300;
////        String devices = "testController";
////        String Pay = "COD";//Pay nhập từ checkout.jsp
////        try {
////            StatusDAO statusDao = new StatusDAO();
////            ServicesDAO serviceDAO = new ServicesDAO();
////
////            Services service = serviceDAO.getServiceByName(OrderDServiceName);
////            int ServiceID = service.getServiceID();
////
////            //OrderDIDevices allow null(DB)
////            String OrderDIDevices = null;
////            Status status = statusDao.details(1);
////
////            OrderDetail orderItem
////                    = new OrderDetail(OrderID, ServiceID, OrderDServiceName, price, devices, Pay, status);
////            OrderDetailDAO orderDetail = new OrderDetailDAO();
////
////            orderDetail.insertOrderDetail(orderItem);\
//
////        try {
////            HttpSession session = request.getSession();
////            Cart cart = (Cart) session.getAttribute("CART");
////            if (cart != null) {
////                //Lấy từ CART(AddToCard)
////                //nhận price, devices, services từ AddToCard
////                Tea tea = new Tea();
////                String OrderDServiceName = tea.getTendv();
////                Services service = serviceDAO.getServiceByName(OrderDServiceName);
////                int ServiceID = service.getServiceID();
////                double OrderDServicePrice = tea.getDongia();
////                //OrderDIDevices allow null(DB)
////                String OrderDIDevices = null;
////                Status status = statusDao.details(1);
////                String Pay = "COD";//Pay nhập từ checkout.jsp
////                int OrderID = orderDao.getIDByLastOrder();
////                OrderDetail orderItem
////                        = new OrderDetail(OrderID, ServiceID, OrderDServiceName, OrderDServicePrice, OrderDIDevices, Pay, status);
////                OrderDetailDAO orderDetail = new OrderDetailDAO();
////                orderDetail.insertOrderDetail(orderItem);
////            CustomerDAO customer = new CustomerDAO();
////            OrdersDAO orderDao = new OrdersDAO();
////            String phone = (String) session.getAttribute("PHONE_USER");
////            Customer customerID = customer.getAccountbyPhone(phone);
////            EmployeeDAO employeeDAO = new EmployeeDAO();
////            Employee employee = employeeDAO.details(1);
////            String OrderNote = "";
////
////            Order order = new Order(OrderNote, customerID, employee);
////            orderDao.create(order);
////                url = "listOfServices.jsp";
//        try {
//            String teaString = request.getParameter("cmbTea");
//            String[] tmp = teaString.split("-");
//            String madv = tmp[0];
//            String tendv = tmp[1];
//            double dongia = Double.parseDouble(tmp[2]);
//            String details = tmp[3];
//            double thoigian = Double.parseDouble(tmp[4]);
//            String hinhanh = tmp[5];
////            int soluong= Integer.parseInt(request.getParameter("cmbQuantity"));
//            HttpSession session = request.getSession();
//            Cart cart = (Cart) session.getAttribute("CART");
//            if (cart == null) {
//                cart = new Cart();
//            }
//            Tea tea = new Tea(madv, tendv, dongia, details, thoigian, hinhanh);
//            cart.add(tea);
//            session.setAttribute("CART", cart);
//            request.setAttribute("MESSAGE", "Add successfully: " + tendv);
//        } catch (Exception ex) {
//            request.getRequestDispatcher(url).forward(request, response);
//        } finally {
//            request.getRequestDispatcher(url).forward(request, response);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//}
