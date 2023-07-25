/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import MyUitl.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Customer;
import model.CustomerDetail;
import model.Employee;
import model.Order;

/**
 *
 * @author Asus
 */
public class CustomerDetailsDAO{

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private DBContext db;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public CustomerDetailsDAO(DBContext db) {
        this.db = db;
    }

    public CustomerDetailsDAO() {
        db = new DBContext();
    }

    List<CustomerDetail> listItems;


//    public CustomerDetail getCustomerDetail(int id) {
//        try {
//            String sql = "select *\n"
//                    + "from CustomerDetails\n"
//                    + "Where CustomerID = ?";
//            PreparedStatement stmt = db.getConn().prepareStatement(sql);
//            stmt.setInt(1, id);
//            rs = stmt.executeQuery();
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                int CustomerDID = Integer.parseInt(rs.getString("CustomerDID"));
//                String Room = rs.getString("Room");
//                int CustomerID = Integer.parseInt(rs.getString("CustomerID"));
//                int Floor = Integer.parseInt(rs.getString("Floor"));
//                String Building = rs.getString("Building");
//                int OrderID = Integer.parseInt(rs.getString("OrderID"));
//
//                CustomerDAO customerDAO = new CustomerDAO();
//                Customer c = customerDAO.getCustomerbyID(CustomerID);
//                OrdersDAO orderDAO = new OrdersDAO();
//                Order o = orderDAO.getOrderByID(OrderID);
//                CustomerDetail item = new CustomerDetail(CustomerDID, Room, Floor, Building, c, o);
//                return item;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return null;
//    }
    
    public CustomerDetail getCustomerNew(int id, int OrderID) {
        try {
            String sql = "select *\n"
                    + "from CustomerDetails\n"
                    + "Where CustomerID = ? and OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, OrderID);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int CustomerDID = Integer.parseInt(rs.getString("CustomerDID"));
                String Address = rs.getString("CustomerAddress");
                int CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                String Phone = rs.getString("Phone");
//                int OrderID = Integer.parseInt(rs.getString("OrderID"));

                CustomerDAO customerDAO = new CustomerDAO();
                Customer c = customerDAO.getCustomerbyID(CustomerID);
                OrdersDAO orderDAO = new OrdersDAO();
                Order o = orderDAO.getOrderByID(OrderID);
                CustomerDetail item = new CustomerDetail(CustomerDID, Address, Phone, c, o);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


//    public void create(CustomerDetail newItem) {
//        String sql = "Insert into CustomerDetails(Room, CustomerID, Floor, Building, OrderID)\n"
//                + "Values(?, ?, ?, ?, ?)";
//
//        try {
//            PreparedStatement stmt = db.getConn().prepareStatement(sql);
//            stmt.setString(1, newItem.getRoomID());
//            stmt.setInt(2, newItem.getCustomer().getCustomerID());
//            stmt.setInt(3, newItem.getFloor());
//            stmt.setString(4, newItem.getBuilding());
//            stmt.setInt(5, newItem.getOrder().getOrderID());
//
//            stmt.executeUpdate(); // dùng khi muốn thêm, sửa, xóa
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerDetailsDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//

    public void create(CustomerDetail newItem) {
        String sql = "Insert into CustomerDetails(CustomerID,OrderID,Phone,CustomerAddress)\n"
                + "Values(?, ?, ?, ?)";

        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, newItem.getCustomer().getCustomerID());
            stmt.setInt(2, newItem.getOrder().getOrderID());
            stmt.setString(3, newItem.getPhone());
            stmt.setString(4, newItem.getCustomerAddress());

            stmt.executeUpdate(); // dùng khi muốn thêm, sửa, xóa
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetailsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        CustomerDetailsDAO dao = new CustomerDetailsDAO();
        String room = "2111";
        String building = "S106";
        int floor = 21;
        CustomerDAO cusDao = new CustomerDAO();
        Customer c = cusDao.getAccountbyPhone("0123456781");
        Date d = new Date(1997, 01, 22);
        Category category = new Category(1, "Dọn dẹp", "Hoạt động", "");
        Employee e = new Employee(6, "Chu Văn C", d, "0123456779", "S202, 2108", "hhhh", true, category);
        Order o = new Order(160, "None", c, e);
//        CustomerDetail cdetail = new CustomerDetail(room, floor, building, c, o);
//        CustomerDetailsDAO cdetailDAO = new CustomerDetailsDAO();
//        CustomerDetail c1 = dao.getCustomerNew(3, 168);
//        cdetailDAO.create(cdetail);
        CustomerDetail cu = dao.getCustomerNew(1, 32);
        System.out.println(cu);
    }
}
