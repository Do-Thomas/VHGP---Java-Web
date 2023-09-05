/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ngân
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String ADMIN = "Admin";
    private static final String ADMIN_PAGE = "LoginAdminController";
    private static final String INDEX = "homepage";
    private static final String INDEX_CONTROLLER = "IndexServices";
    private static final String LISTSERVICES = "ListService";
    private static final String LIST_ALL_SERVICES = "ListAllServices";
    private static final String ADD = "Add";
    private static final String ADD_TO_CARD_CONTROLLER = "AddToCartController";
    private static final String VIEW = "View";
    private static final String VIEW_CARD_PAGE = "ViewCart.jsp";
    private static final String EDIT = "Edit";
    private static final String EDIT_CARD_CONTROLLER = "EditCartController";
    private static final String REMOVE = "Remove";
    private static final String REMOVE_CARD_CONTROLLER = "RemoveCartController";
    private static final String UPDATE = "Update";
    private static final String UPDATE_SERVICES = "UpdateServices";
    private static final String CREATE = "Create";
    private static final String CREATE_SERVICES = "CreateServices";
    private static final String HOUR = "Price";
    private static final String HOUR_SERVICES = "EditDetailsService";
    private static final String DELETE = "Delete";
    private static final String DELETE_SERVICE = "DeleteServices";
    private static final String DETAILADMIN = "Details";
    private static final String DETAILS_ADMIN = "DetailsServiceAdmin";
    private static final String DETAIL = "Detail";
    private static final String DETAILS_SERVICE = "DetailsService";

    private static final String INDEXCATEGORY = "Category";
    private static final String LIST_CATEGORY = "ListOfCategory";
    private static final String UPDATECATEGORY = "UpdateCat";
    private static final String UPDATE_CATEGORY = "UpdateCategory";
    private static final String CREATECATEGORY = "CreateCat";
    private static final String CREATE_CATEGORY = "CreateCategory";
    private static final String EMPLOYEE = "Employee";
    private static final String EMPLOYEE_LOGIN = "LoginEmployee";
    private static final String LOGIN_EMPLOYEE = "registerEmp";
    private static final String REGISTER_EMPLOYEE = "RegisterEmployee";

    private static final String HISTORY = "History";
    private static final String HISTORY_ORDER = "HistoryOrderController";
    private static final String CHECKOUT = "Checkout";
    private static final String CHECKOUTCONTROLLER = "CheckOutController";
    private static final String INSERT = "Payment";
    private static final String INSERT_ORDER = "InsertOrderController";
    private static final String CANCEL = "Cancel";
    private static final String CANCEL_ORDER = "CancelOrder";
    private static final String GIA = "Gia";
    private static final String GIA_SERVICES = "DisplayPrice";
    private static final String REMOVEALL = "Remove All";
    private static final String REMOVEALL_CARD_CONTROLLER = "RemoveAllCart";

    private static final String SEARCH = "search";
    private static final String SEARCH_CONTROLLER = "search";
    private static final String INDEXMARKETING = "Marketing";
    private static final String LIST_MARKETING = "ListOfmarketing";
    private static final String CREATEMARKETING = "CreateMarketing";
    private static final String CREATE_MARKETING = "CreateMarketing";
    private static final String UPDATEMARKETING = "UpdateMarketing";
    private static final String UPDATE_MARKETING = "UpdateMarketing";
    private static final String CATDONDEP = "Show";
    private static final String SHOW_CAT = "ShowServicesDondepCategory";
    private static final String CATDONDEPHOME = "ShowHome";
    private static final String SHOW_CAT_HOME = "ShowServiceCategoryHome";

    private static final String ADMIN_PROFILE = "ViewA";
    private static final String ADMIN_VIEW = "ViewAdmin";
    private static final String CANCELSER = "CanSer";
    private static final String CANCEL_SERVICES = "CancelServices";

    private static final String INDEXALPA = "Alpha";
    private static final String LISTAP_SERVICES = "ListAllServiceAlpha";
    private static final String INDEXZA = "AlphaZA";
    private static final String LISTZA_SERVICES = "ListAllServiceAlphaZA";
    private static final String INDEXPAZ = "PriceAZ";
    private static final String LISTPAZ_SERVICES = "ListAllServicePriceAZ";
    private static final String INDEXPZA = "PriceZA";
    private static final String LISTPZA_SERVICES = "ListAllServicePriceZA";
//    private static final String DELIVERY = "DeliveryServlet";
//    private static final String DELIVERYSERVLET = "DeliveryServlet";
    private static final String SHOW = "ShowCart";
    private static final String SHOWSERVLET = "ShowDate";
    private static final String ALLEMPLOYEE = "AllEmp";
    private static final String ALL_EMPLOYEE = "AllEmployeeController";
    private static final String ALLJOB = "AllJob";
    private static final String ALL_EMPLOYEE_JOBS = "AllJobController";
    private static final String ALLORDER = "AllOrder";
    private static final String ALLORDER_STATUS = "AllOrderController";
    private static final String DELI = "ShowDelivery";
    private static final String DELISERVLET = "DeliveryServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (ADMIN.equals(action)) {
                url = ADMIN_PAGE;
            } else if (EMPLOYEE.equals(action)) {
                url = EMPLOYEE_LOGIN;
            } else if (INDEX.equals(action)) {
                url = INDEX_CONTROLLER;
            } else if (LISTSERVICES.equals(action)) {
                url = LIST_ALL_SERVICES;
            } else if (ADD.equals(action)) {
                url = ADD_TO_CARD_CONTROLLER;
            } else if (VIEW.equals(action)) {
                url = VIEW_CARD_PAGE;
            } else if (EDIT.equals(action)) {
                url = EDIT_CARD_CONTROLLER;
            } else if (REMOVE.equals(action)) {
                url = REMOVE_CARD_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if (UPDATE.equals(action)) {
                url = UPDATE_SERVICES;
            } else if (CREATE.equals(action)) {
                url = CREATE_SERVICES;
            } else if (DELETE.equals(action)) {
                url = DELETE_SERVICE;
            } else if (DETAIL.equals(action)) {
                url = DETAILS_SERVICE;
            } else if (INDEXCATEGORY.equals(action)) {
                url = LIST_CATEGORY;
            } else if (CREATECATEGORY.equals(action)) {
                url = CREATE_CATEGORY;
            } else if (UPDATECATEGORY.equals(action)) {
                url = UPDATE_CATEGORY;
            } else if (HOUR.equals(action)) {
                url = HOUR_SERVICES;
            } else if (HISTORY.equals(action)) {
                url = HISTORY_ORDER;
            } else if (CHECKOUT.equals(action)) {
                url = CHECKOUTCONTROLLER;
            } else if (CANCEL.equals(action)) {
                url = CANCEL_ORDER;
            } else if (INSERT.equals(action)) {
                url = INSERT_ORDER;
            } else if (GIA.equals(action)) {
                url = GIA_SERVICES;
            } else if (REMOVEALL.equals(action)) {
                url = REMOVEALL_CARD_CONTROLLER;
            } else if (CREATEMARKETING.equals(action)) {
                url = CREATE_MARKETING;
            } else if (UPDATEMARKETING.equals(action)) {
                url = UPDATE_MARKETING;
            } else if (INDEXMARKETING.equals(action)) {
                url = LIST_MARKETING;
            } else if (DETAILADMIN.equals(action)) {
                url = DETAILS_ADMIN;
            } else if (CATDONDEP.equals(action)) {
                url = SHOW_CAT;
            } else if (CATDONDEPHOME.equals(action)) {
                url = SHOW_CAT_HOME;
            } else if (ADMIN_PROFILE.equals(action)) {
                url = ADMIN_VIEW;
            } else if (CANCELSER.equals(action)) {
                url = CANCEL_SERVICES;
            } else if (INDEXALPA.equals(action)) {
                url = LISTAP_SERVICES;
            } else if (INDEXZA.equals(action)) {
                url = LISTZA_SERVICES;
            } else if (INDEXPAZ.equals(action)) {
                url = LISTPAZ_SERVICES;
            } else if (INDEXPZA.equals(action)) {
                url = LISTPZA_SERVICES;
            } 
//            else if (DELI.equals(action)) {
//                url = DELISERVLET;
//            } 
            else if (SHOW.equals(action)) {
                url = SHOWSERVLET;
            } else if (ALLEMPLOYEE.equals(action)) {
                url = ALL_EMPLOYEE;
            } else if (ALLJOB.equals(action)) {
                url = ALL_EMPLOYEE_JOBS;
            } else if (ALLORDER.equals(action)) {
                url = ALLORDER_STATUS;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
