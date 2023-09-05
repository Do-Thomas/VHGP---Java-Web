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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Role;

public class CustomerDAO {

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

    public CustomerDAO(DBContext db) {
        this.db = db;
    }

    public CustomerDAO() {
        this.db = new DBContext();
    }

    public CustomerDAO(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public List<Customer> getCustomer() {
        List<Customer> list = new ArrayList<>();
        try {
            String sql = "select * from Customer";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ID = Integer.parseInt(rs.getString("CustomerID"));
                String _CustomerName = rs.getString("CustomerName");
                list.add(new Customer(_ID, _CustomerName));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Customer details(int id) {

        try {
            String sql = "Select CustomerID, CustomerName, Phone, Password, BirthDay, Email, CustomerAddress, Gender\n"
                    + "From Customer\n"
                    + "Where CustomerID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ID = Integer.parseInt(rs.getString("CustomerID"));
                String _CustomerName = rs.getString("CustomerName");
                String _Phone = rs.getString("Phone");
                String _Password = rs.getString("Password");
                Date _BirthDay = (Date) rs.getDate("BirthDay");
                String _Email = rs.getString("Email");
                String _CustomerAddress = rs.getString("CustomerAddress");
                Boolean _Gender = rs.getBoolean("Gender");
//                String _RoleID = rs.getString("RoleID");

                Customer item = new Customer(_ID, _CustomerName, _Phone, _Password, _BirthDay, _CustomerAddress, _Gender);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    private static final String INSERT = "INSERT INTO Customer( CustomerName, Phone, Password, BirthDay,Email, CustomerAddress, Gender,RoleID) VALUES(?,?,?,?,?,?,?,?)";

    public boolean insert(Customer user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = db.getConn();
            if (conn != null) {

                ptm = conn.prepareStatement(INSERT);
//            ptm.setInt(1, user.getCustomerID());
                ptm.setString(1, user.getCustomerName());
                ptm.setString(2, user.getPhone());
                ptm.setString(3, user.getPassword());
//java.util.Date utilDate = user.getBirthDay();
//java.sql.Date sqlDate = new java.sql.Date(utilDate.getDate());
                ptm.setDate(4, new java.sql.Date(user.getBirthDay().getTime()));
                ptm.setString(5, user.getEmail());
                ptm.setString(6, user.getCustomerAddress());
                ptm.setBoolean(7, user.getGender());
                ptm.setObject(8, user.getRole().getRoleID()); // Assuming the Role object has an ID property

                ptm.executeUpdate();

            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    private final RoleDAO dao = new RoleDAO();

    public Customer checkLogin(String sdt, String matkhau) throws SQLException {
        Customer user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "  SELECT * from Customer\n"
                + " WHERE Phone=? AND Password=? ";
        try {
            conn = db.getConn();
            if (conn != null) {
                PreparedStatement stmt = db.getConn().prepareStatement(sql);
                stmt.setString(1, sdt);
                stmt.setString(2, matkhau);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    int _ID = Integer.parseInt(rs.getString("CustomerID"));
                    String _CustomerName = rs.getString("CustomerName");
                    Date _BirthDay = (Date) rs.getDate("BirthDay");
                    String _Email = rs.getString("Email");
                    String _CustomerAddress = rs.getString("CustomerAddress");
                    Boolean _Gender = rs.getBoolean("Gender");
                    String _RoleID = rs.getString("RoleID");
                    Role _RoleIDCustomer = dao.details(_RoleID);
                    return (Customer) new Customer(_ID, _CustomerName, sdt, matkhau, _BirthDay, _Email, _CustomerAddress, _Gender, _RoleIDCustomer);
//                    return (TaiKhoan)new TaiKhoan(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4),rs.getObject(email, type));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Customer edittedItem) {
        try {
            String sql = "UPDATE Customer SET CustomerName=?, Phone=?, Password=?, BirthDay=?, Email=?, CustomerAddress=?, Gender=?  WHERE CustomerID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, edittedItem.getCustomerName());
            stmt.setString(2, edittedItem.getPhone());
            stmt.setString(3, edittedItem.getPassword());
            stmt.setDate(4, new java.sql.Date(edittedItem.getBirthDay().getTime()));
            stmt.setString(5, edittedItem.getEmail());
            stmt.setString(6, edittedItem.getCustomerAddress());
            stmt.setBoolean(7, edittedItem.isGender());
//            stmt.setString(8, edittedItem.getRole().getRoleID());
            stmt.setInt(8, edittedItem.getCustomerID());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer getAccountbyPhone(String phone) {
        try {
            String sql = "select *\n"
                    + "from Customer\n"
                    + "where phone = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, phone);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ID = Integer.parseInt(rs.getString("CustomerID"));
                String _CustomerName = rs.getString("CustomerName");
                String _Phone = rs.getString("Phone");
                String _Password = rs.getString("Password");
                Date _BirthDay = (Date) rs.getDate("BirthDay");
                String _Email = rs.getString("Email");
                String _CustomerAddress = rs.getString("CustomerAddress");
                Boolean _Gender = rs.getBoolean("Gender");
                String _RoleID = rs.getString("RoleID");
                RoleDAO roleDAO = new RoleDAO();
                Role role = roleDAO.details(_RoleID);

                Customer item = new Customer(_ID, _CustomerName, phone, _Password,
                        _BirthDay, _Email, _CustomerAddress, _Gender, role);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Customer getCustomerbyPhoneCS(String phone) {
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
                int _ID = Integer.parseInt(rs.getString("CustomerID"));
                String _CustomerName = rs.getString("CustomerName");
                String _Phone = rs.getString("Phone");
                String _Password = rs.getString("Password");
                Date _BirthDay = (Date) rs.getDate("BirthDay");
                String _Email = rs.getString("Email");
                String _CustomerAddress = rs.getString("CustomerAddress");
                Boolean _Gender = rs.getBoolean("Gender");
                String _RoleID = rs.getString("RoleID");
                RoleDAO roleDAO = new RoleDAO();
                Role role = roleDAO.details(_RoleID);

                Customer item = new Customer(_ID, _CustomerName, phone, _Password,
                        _BirthDay, _Email, _CustomerAddress, _Gender, role);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Customer getCustomerbyID(int CustomerID) {
        try {
            String sql = "select *\n"
                    + "from Customer\n"
                    + "where CustomerID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, CustomerID);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ID = Integer.parseInt(rs.getString("CustomerID"));
                String _CustomerName = rs.getString("CustomerName");
                String _Phone = rs.getString("Phone");
                String _Password = rs.getString("Password");
                Date _BirthDay = (Date) rs.getDate("BirthDay");
                String _Email = rs.getString("Email");
                String _CustomerAddress = rs.getString("CustomerAddress");
                Boolean _Gender = rs.getBoolean("Gender");
                String _RoleID = rs.getString("RoleID");
                RoleDAO roleDAO = new RoleDAO();
                Role role = roleDAO.details(_RoleID);

                Customer item = new Customer(_ID, _CustomerName, _Phone, _Password,
                        _BirthDay, _Email, _CustomerAddress, _Gender, role);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Customer getCustomerbyPhone(String phone) {
        try {
            String sql = "select *\n"
                    + "from Customer\n"
                    + "where phone = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, phone);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ID = Integer.parseInt(rs.getString("CustomerID"));
                String _CustomerName = rs.getString("CustomerName");
                String _Phone = rs.getString("Phone");
                String _Password = rs.getString("Password");
                Date _BirthDay = (Date) rs.getDate("BirthDay");
                String _Email = rs.getString("Email");
                String _CustomerAddress = rs.getString("CustomerAddress");
                Boolean _Gender = rs.getBoolean("Gender");
                String _RoleID = rs.getString("RoleID");
                RoleDAO roleDAO = new RoleDAO();
                Role role = roleDAO.details(_RoleID);

                Customer item = new Customer(_ID, _CustomerName, phone, _Password,
                        _BirthDay, _Email, _CustomerAddress, _Gender, role);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int getCountOrder(int CustomerID) {
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        int Count = 0;
        try {
            String sql = "Select  COUNT(cp.CustomerID)\n"
                    + "From Customer c\n"
                    + "inner join ConfirmPay cp\n"
                    + "on c.CustomerID = cp.CustomerID\n"
                    + "inner join Status s\n"
                    + "on s.StatusID = cp.StatusID\n"
                    + "Where c.CustomerID = ? and cp.Status LIKE N'DONE' and s.OrderDate >= '2023-01-01' and s.OrderDate <= '2023-12-31'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, CustomerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Count = rs.getInt(1);
                return Count;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Count;
    }

    //Test detail
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        Customer c = dao.getCustomerbyPhoneCS("0234567891");
        System.out.println(c.getCustomerName());
        System.out.println(c.getCustomerID());
    }

}
