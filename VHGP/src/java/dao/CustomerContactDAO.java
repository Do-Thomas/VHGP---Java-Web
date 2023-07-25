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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Customer_contact;
import model.Role;

/**
 *
 * @author ADMIN
 */
public class CustomerContactDAO {

    List<Customer> listCustomer;
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

    public CustomerContactDAO(DBContext db) {
        this.db = db;
    }

    public CustomerContactDAO() {
        this.db = new DBContext();
    }

    public CustomerContactDAO(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void addCustomerContact(Customer customerContact) throws Exception {
        try {
            String sql = "INSERT INTO Customer_contact (CustomerID, Phone, CustomerAddress) VALUES (?, ?, ?)";
              PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setInt(1, customerContact.getCustomerID());
            ps.setString(3, customerContact.getCustomerAddress());
            ps.setString(2, customerContact.getPhone());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public List<Customer> getAddressPhoneList(int CustomerID) throws Exception {
        List<Customer> addressPhoneList = new ArrayList<>();

        try {
            String sql = "SELECT CustomerAddress, Phone FROM Customer_contact WHERE CustomerID = ?";
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setInt(1, CustomerID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String CustomerAddress = rs.getString("CustomerAddress");
                String Phone = rs.getString("Phone");

                Customer user = new Customer();
                user.setCustomerAddress(CustomerAddress);
                user.setPhone(Phone);
                addressPhoneList.add(user);
            }

            rs.close();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return addressPhoneList;
    }
    
    
    public Customer_contact getCustomerbyPhoneCS(String phone) {
        try {
            String sql = "select *\n"
                    + "from Customer_contact c\n"
                    + "inner join Customer cs\n"
                    + "on c.CustomerID = cs.CustomerID\n"
                    + "where c.phone = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, phone);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ID = Integer.parseInt(rs.getString("contact_id"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                String _Phone = rs.getString("Phone");
                String _Address = rs.getString("CustomerAddress");
                CustomerDAO cd = new CustomerDAO();
                Customer Customer = cd.getCustomerbyID(_CustomerID);
                
                Customer_contact item = new Customer_contact(Customer, phone, _Address);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public void deleteCustomerContact(int customerID, String phone, String customerAddress) throws Exception {
        try {
            String sql = "DELETE FROM Customer_contact WHERE CustomerID = ? AND Phone = ? AND CustomerAddress = ?";
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setInt(1, customerID);
            ps.setString(2, phone);
            ps.setString(3, customerAddress);
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public boolean checkDuplicateContact(String phone, String address) throws SQLException, Exception {
        try {
            String sql = "SELECT COUNT(*) FROM Customer_contact WHERE Phone = ? AND CustomerAddress = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, phone);
            stmt.setString(2, address);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return false;
    }
    
    public boolean checkDuplicateAddress(String address) throws SQLException, Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Customer_contact WHERE  CustomerAddress = ?";
            stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, address);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return false;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        CustomerContactDAO dao = new CustomerContactDAO();
//        List<Customer> list = dao.getAddressPhoneList(2);
//        for (Customer customer : list) {
//            System.out.println(customer);
//        }
        Customer_contact item = dao.getCustomerbyPhoneCS("0234567891");
        System.out.println(item);
    }

}
