/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import MyUitl.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConfirmPay;
import model.Customer;
import model.Employee;
import model.Order;
import model.Status;

/**
 *
 * @author Asus
 */
public class ConfirmPayDAO {

    List<ConfirmPay> listConfirmPay;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    OrdersDAO orderDAO = new OrdersDAO();
    EmployeeDAO employeeDAO = new EmployeeDAO();
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

    private DBContext db;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public ConfirmPayDAO(DBContext db) {
        this.db = db;
    }

    public ConfirmPayDAO() {
        this.db = new DBContext();
    }

    public ConfirmPayDAO(List<ConfirmPay> listConfirmPay) {
        this.listConfirmPay = listConfirmPay;
    }

    public List<ConfirmPay> getListConfirmPay() {
        return listConfirmPay;
    }

    public void createConfirm(ConfirmPay newItem) {
        String sql = "Insert into ConfirmPay(StatusID, CustomerID, ConfirmEmp, ConfirmCus, Status) Values(?,?,?,?,?)";

        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
//            stmt.setInt(1, newItem.getStatusID());
            stmt.setObject(1, newItem.getStatus().getStatusID());
            stmt.setInt(2, newItem.getCustomer().getCustomerID());
            stmt.setString(3, newItem.getConfirmEmp());
            stmt.setString(4, newItem.getConfirmCus());
            stmt.setString(5, newItem.getStatusPay());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateConfirm(ConfirmPay edittedItem) {
        try {
            String sql = "Update ConfirmPay SET ConfirmCus = 'Done', Status = 'Done' Where StatusID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setInt(1, edittedItem.getStatus().getStatusID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ConfirmPay> getBillConfirm(int CustomerID) throws ParseException {
        List<ConfirmPay> listItem = new ArrayList<>();
        try {
            String sql = "select *\n"
                    + "From ConfirmPay cp\n"
                    + "inner join Status s\n"
                    + "on s.StatusID = cp.StatusID\n"
                    + "where cp.CustomerID = ? and s.StatusName LIKE N'Hoàn thành' and cp.Status LIKE N'Not Done'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, CustomerID);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int ConfirmID = Integer.parseInt(rs.getString("ConfirmID"));
                int StatusID = Integer.parseInt(rs.getString("StatusID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                String ConfirmEmp = rs.getString("ConfirmEmp");
                String ConfirmCus = rs.getString("ConfirmCus");
                String Status = rs.getString("Status");
                
                CustomerDAO CustomerDAO = new CustomerDAO();
                Customer c = CustomerDAO.getCustomerbyID(CustomerID);
                StatusDAO StatusDAO = new StatusDAO();
                Status s  = StatusDAO.getStatusbyID(StatusID);
                
                ConfirmPay item = new ConfirmPay(ConfirmEmp, ConfirmCus, Status, s, c);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }
    
    public ConfirmPay getConfirm(int CustomerID) throws ParseException {
        
        try {
            String sql = "select *\n"
                    + "From ConfirmPay cp\n"
                    + "inner join Status s\n"
                    + "on s.StatusID = cp.StatusID\n"
                    + "where cp.CustomerID = ? and s.StatusName LIKE N'Hoàn thành'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, CustomerID);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int ConfirmID = Integer.parseInt(rs.getString("ConfirmID"));
                int StatusID = Integer.parseInt(rs.getString("StatusID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                String ConfirmEmp = rs.getString("ConfirmEmp");
                String ConfirmCus = rs.getString("ConfirmCus");
                String Status = rs.getString("Status");
                
                CustomerDAO CustomerDAO = new CustomerDAO();
                Customer c = CustomerDAO.getCustomerbyID(CustomerID);
                StatusDAO StatusDAO = new StatusDAO();
                Status s  = StatusDAO.getStatusbyID(StatusID);
                
                ConfirmPay item = new ConfirmPay(ConfirmEmp, ConfirmCus, Status, s, c);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void main(String[] args) throws ParseException {
        ConfirmPayDAO confirm = new ConfirmPayDAO();
        Employee e = new Employee(16, "Trần Thi Hoa");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        Customer c = new Customer(1, "Trần Văn A", "0123456781", "12345", date, "avt@gmail.com", "S101, 1999", true);
        Order o = new Order(6);
        Status s = new Status(7, "Hoàn thành", date, o);
        String ConfirmEmp = "Done";
        String ConfirmCus = null;
        String StatusPay = "Note Done";

        ConfirmPay con = new ConfirmPay(ConfirmEmp, ConfirmCus, StatusPay, s, c);
        confirm.createConfirm(con);
//        List<ConfirmPay> list = confirm.getBillConfirm(2);
//        for (ConfirmPay confirmPay : list) {
//            System.out.println("====================================================");
//            System.out.println("Name: " + confirmPay.getCustomer().getCustomerName());
//            System.out.println("Phone: " + confirmPay.getCustomer().getPhone());
//            System.out.println("Nhân viên: " + confirmPay.getStatus().getEmployee().getEmployeeName());
//            System.out.println("Dịch vụ: " + confirmPay.getStatus().getOrderDetail().getOrderDServiceName());
//            System.out.println("Giá: " + confirmPay.getStatus().getOrderDetail().getOrderDServicePrice());
//            System.out.println("Bắt đầu: " + confirmPay.getStatus().getOrderDetail().getTimeStart());
//            System.out.println("Kết thúc: " + confirmPay.getStatus().getOrderDetail().getTimeStart());
//            System.out.println("Pay: " + confirmPay.getStatus().getOrderDetail().getPay());
//            System.out.println("" + confirmPay.getStatusPay());
//            System.out.println(confirmPay.getStatus().getStatusID());
//        }

    }
}
