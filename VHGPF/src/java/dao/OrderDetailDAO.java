/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import MyUitl.DBContext;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CustomerDetail;
import model.Employee;
import model.Order;
import model.OrderDetail;
import model.Services;
import model.Status;

/**
 *
 * @author Asus
 */
public class OrderDetailDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private static PreparedStatement stm = null;
    CustomerDAO cDao = new CustomerDAO();
    EmployeeDAO eDao = new EmployeeDAO();

    private DBContext db;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public OrderDetailDAO(DBContext db) {
        this.db = db;
    }

    public OrderDetailDAO() {
        db = new DBContext();
    }

    List<Order> listItems;

    public OrderDetailDAO(List<Order> listItems) {
        this.listItems = listItems;
    }

    public List<Order> getListItems() {
        return listItems;
    }

    public void setListItems(List<Order> listItems) {
        this.listItems = listItems;
    }

    //Test - chạy
    public List<OrderDetail> getStatusOrder(String Status, int CustomerID) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();

        try {
            String sql = "Select *\n"
                    + "From Orders o\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "inner join OrderDetails od \n"
                    + "on o.OrderID = od.OrderID\n"
                    + "Where s.StatusName like ? and o.CustomerID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + Status + "%");
            stmt.setInt(2, CustomerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _Status = rs.getString("Status");
                String _Pay = rs.getString("Pay");

                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);
                java.sql.Date End = new java.sql.Date(timeEnd.getTime());
                int ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));

                StatusDAO statusDAO = new StatusDAO();
                Status StatusID = statusDAO.details(_OrderID);
                OrderDetail item = new OrderDetail(_OrderID, _ServiceID, _OrderDServiceName,
                        _OrderDServicePrice, _OrderDIDevices, _Pay, Status, StatusID, timeStart, timeEnd, ServiceTime);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public void update(OrderDetail edittedItem) {
        try {
            String sql = "Update OrderDetails\n"
                    + "Set Status = N'Tạm dừng'\n"
                    + "Where OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

//            stmt.setInt(1, edittedItem.getServiceID());
//            stmt.setString(2, edittedItem.getOrderDServiceName());
//            stmt.setDouble(3, edittedItem.getOrderDServicePrice());
//            stmt.setString(4, edittedItem.getOrderDIDevics());
//            stmt.setInt(5, edittedItem.getStatusObject().getStatusID());
//            stmt.setString(6, edittedItem.getStatus());
//            stmt.setString(7, edittedItem.getPay());
//            stmt.setInt(8, edittedItem.getOrderID());
//              stmt.setString(1, edittedItem.getStatus());
            stmt.setInt(1, edittedItem.getOrderID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateOrderDetail(OrderDetail edittedItem) {
        try {
            String sql = "Update OrderDetails SET timeStart = ?,timeEnd = ? "
                    + "Where OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setTimestamp(1, (Timestamp) edittedItem.getTimeStart());
            stmt.setTimestamp(2, (Timestamp) edittedItem.getTimeEnd());
            stmt.setInt(3, edittedItem.getOrderID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteOrderDetail(int OrderID) {
        String sql = "delete from OrderDetails where OrderID = ?";
        try {
            PreparedStatement st = db.getConn().prepareStatement(sql);
            st.setInt(1, OrderID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertOrderDetail(OrderDetail newItem) throws SQLException {
        try {
            String sql = "Insert into OrderDetails(OrderID, ServiceID, "
                    + "OrderDServiceName, OrderDServicePrice, OrderDIDevices,ServiceTime, Pay, Status, timeStart, timeEnd)\n"
                    + "Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            //Id set identity(1,1) - khỏi thêm
            stmt.setInt(1, newItem.getOrderID());
            stmt.setInt(2, newItem.getServiceID());
            stmt.setString(3, newItem.getOrderDServiceName());
            stmt.setDouble(4, newItem.getOrderDServicePrice());
            stmt.setString(5, newItem.getOrderDIDevics());
            stmt.setInt(6, newItem.getServiceTime());
            stmt.setString(7, newItem.getPay());
            stmt.setString(8, newItem.getStatus());
            stmt.setTimestamp(9, (java.sql.Timestamp) newItem.getTimeStart());
            stmt.setTimestamp(10, (java.sql.Timestamp) newItem.getTimeEnd());

            stmt.executeUpdate();
            //end if connection is existed
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<OrderDetail> getOrderEmployee(int EmployeeID) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "Select *\n"
                    + "from OrderDetails od\n"
                    + "inner join Orders o \n"
                    + "on od.OrderID = o.OrderID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "where s.StatusName Like N'Hoạt động' and o.EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");

                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);
                java.sql.Date End = new java.sql.Date(timeEnd.getTime());

//                Date timeStart = Date.valueOf(rs.getString("timeStart"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
                Order OrderID = cDao.details(_OrderID);
                OrderDetail item = new OrderDetail(_OrderID, _ServiceID, _OrderDServiceName,
                        _OrderDServicePrice, _OrderDIDevices, Pay, Status, timeStart, timeEnd);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public OrderDetail getObjectEmployee(int EmployeeID, int OrderID) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "Select *\n"
                    + "from OrderDetails od\n"
                    + "inner join Orders o \n"
                    + "on od.OrderID = o.OrderID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "where s.StatusName Like N'Hoạt động' and o.EmployeeID = ? and o.OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            stmt.setInt(2, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");

                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

//                Date timeStart = Date.valueOf(rs.getString("timeStart"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
                Order Order = cDao.details(OrderID);
                OrderDetail item = new OrderDetail(OrderID, _ServiceID, _OrderDServiceName,
                        _OrderDServicePrice, _OrderDIDevices, Pay, Status, timeStart, timeEnd, _ServiceTime);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public OrderDetail getBill(int OrderID) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "Select *\n"
                    + "from OrderDetails od\n"
                    + "inner join Orders o \n"
                    + "on od.OrderID = o.OrderID\n"
                    + "where o.OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");

                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

                Order Order = cDao.details(OrderID);
                OrderDetail item = new OrderDetail(OrderID, _ServiceID, _OrderDServiceName,
                        _OrderDServicePrice, _OrderDIDevices, Pay, Status, timeStart, timeEnd, _ServiceTime);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //Admin
    public OrderDetail getDetailOrder(int OrderID) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        OrdersDAO cDao = new OrdersDAO();
        ServicesDAO ServiceDAO = new ServicesDAO();
        try {
            String sql = "Select * from OrderDetails\n"
                    + "Where OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");

                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

                Order Order = cDao.details(OrderID);
                Services Service = ServiceDAO.getServiceByID(_ServiceID);
                OrderDetail item = new OrderDetail(OrderID, _ServiceID, _OrderDServiceName, _OrderDServicePrice,
                        _OrderDIDevices, Pay, Status, timeStart, timeEnd, _ServiceTime, Service);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<OrderDetail> getEmployee(int EmployeeID) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "Select *\n"
                    + "from OrderDetails od\n"
                    + "inner join Orders o \n"
                    + "on od.OrderID = o.OrderID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "where s.StatusName Like N'Hoạt động' and o.EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");
                int OrderID = Integer.parseInt(rs.getString("OrderID"));
                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

//                Date timeStart = Date.valueOf(rs.getString("timeStart"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
                Order Order = cDao.details(OrderID);
                OrderDetail item = new OrderDetail(OrderID, _ServiceID, _OrderDServiceName,
                        _OrderDServicePrice, _OrderDIDevices, Pay, Status, timeStart, timeEnd, _ServiceTime);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public OrderDetail getEmployeeItem(int EmployeeID) throws ParseException {
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "Select *\n"
                    + "from OrderDetails od\n"
                    + "inner join Orders o \n"
                    + "on od.OrderID = o.OrderID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "where s.StatusName Like N'Hoạt động' and o.EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");
                int OrderID = Integer.parseInt(rs.getString("OrderID"));
                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

                Employee emp = eDao.getEmployeebyOrderID(OrderID);
                Order Order = cDao.details(OrderID);
                OrderDetail item = new OrderDetail(OrderID, _ServiceID, _OrderDServiceName, _OrderDServicePrice,
                        _OrderDIDevices, Pay, Status, timeStart, timeEnd, _ServiceTime, emp);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<OrderDetail> getListJob(int EmployeeID) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "select distinct *\n"
                    + "from OrderDetails od\n"
                    + "inner join Orders o\n"
                    + "on od.OrderID = o.OrderID\n"
                    + "inner join Employee e\n"
                    + "on o.EmployeeID = e.EmployeeID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "Where e.EmployeeID = ?  and s.StatusName LIKE N'Hoạt động'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
//                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");
                int OrderID = Integer.parseInt(rs.getString("OrderID"));
                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);
                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

                StatusDAO StatusDAO = new StatusDAO();
                Status Status = StatusDAO.getStatus(OrderID);
                EmployeeDAO EmployeeDAO = new EmployeeDAO();
                Employee Employee = EmployeeDAO.getEmployeebyOrderID(OrderID);

                Order Order = cDao.details(OrderID);
                OrderDetail item = new OrderDetail(OrderID, _ServiceID, _OrderDServiceName, _OrderDServicePrice,
                        _OrderDIDevices, Pay, Status, timeStart, timeEnd, _ServiceTime, Employee);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public Date getDateByLastOrderDetail() throws SQLException {
        java.util.Date utilDate = null;
        try {
            String sql = "select top 1 * from OrderDetails \n"
                    + "ORDER BY timeEnd  desc";
            PreparedStatement stmt;
            stm = db.getConn().prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                java.util.Date date = rs.getDate(10);
                utilDate = new java.util.Date(date.getTime());
                return utilDate;
            }
        } //end if connection is existed
        catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utilDate;
    }

    public OrderDetail getDateLast() throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "select top 1 * from OrderDetails \n"
                    + "where timeEnd > GETDATE()\n"
                    + "ORDER BY timeEnd  asc ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String datetimeStart = rs.getString("timeEnd");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                OrderDetail item = new OrderDetail(timeStart);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<OrderDetail> getStatusOrders(int CustomerID) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();

        try {
            String sql = "Select *\n"
                    + "From Orders o\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "inner join OrderDetails od \n"
                    + "on o.OrderID = od.OrderID\n"
                    + "Where o.CustomerID = ?\n"
                    + "ORDER BY o.OrderID DESC";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, CustomerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _Status = rs.getString("Status");
                String _Pay = rs.getString("Pay");

                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

//                Date timeStart = Date.valueOf(rs.getString("timeStart"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
                StatusDAO statusDAO = new StatusDAO();
                Status StatusID = statusDAO.details(_OrderID);
                OrderDetail item = new OrderDetail(_OrderID, _ServiceID, _OrderDServiceName,
                        _OrderDServicePrice, _OrderDIDevices, _Pay, _Status, timeStart, timeEnd, _ServiceTime);

                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public OrderDetail getOrderDetailbyID(int OrderID) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "select *\n"
                    + "from OrderDetails \n"
                    + "Where OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

//                Date timeStart = Date.valueOf(rs.getString("timeStart"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
//                Date timeEnd = Date.valueOf(rs.getString("timeEnd"));
                Order Order = cDao.details(OrderID);
                OrderDetail item = new OrderDetail(OrderID, _ServiceID, _OrderDServiceName,
                        _OrderDServicePrice, _OrderDIDevices, Pay, Status, timeStart, timeEnd, _ServiceTime);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int moneymonth(int month) {
        try {
            String sql = "SELECT SUM(OrderDServicePrice) FROM OrderDetails WHERE MONTH(timeStart) = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, month);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int sum = rs.getInt(1);
                return sum;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int moneyStat(String date) {
        try {
            String sql = "SELECT SUM(OrderDServicePrice) AS TotalRevenue\n"
                    + "FROM OrderDetails\n"
                    + "WHERE CAST(timeStart AS DATE) = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int totalRevenue = rs.getInt("TotalRevenue");
                return totalRevenue;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int moneyStatRange(String startDate, String endDate) {
        try {
            String sql = "SELECT SUM(OrderDServicePrice) AS TotalRevenue\n"
                    + "FROM OrderDetails od\n"
                    + "INNER JOIN Status s ON od.OrderID = s.OrderID\n"
                    + "INNER JOIN ConfirmPay cp ON s.StatusID = cp.StatusID\n"
                    + "WHERE s.StatusName LIKE N'Hoàn thành' AND cp.ConfirmEmp LIKE N'DONE'\n"
                    + "AND CAST(od.timeStart AS DATE) >= ? \n"
                    + "AND CAST(od.timeStart AS DATE) <= ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, startDate);
            stmt.setString(2, endDate);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int totalRevenue = rs.getInt("TotalRevenue");
                return totalRevenue;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<OrderDetail> getManageOrder() throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        StatusDAO statusDAO = new StatusDAO();
        OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
        CustomerDetailsDAO customerDetailDAO = new CustomerDetailsDAO();

        try {
            String sql = "Select *\n"
                    + "From OrderDetails od\n"
                    + "inner join Status s\n"
                    + "on od.OrderID = s.OrderID\n"
                    + "inner join CustomerDetails cd\n"
                    + "on od.OrderID = cd.OrderID\n"
                    + "Where s.EmployeeID = 10000 and s.StatusName LIKE N'Hoạt động'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

                CustomerDetail itemCustomer = customerDetailDAO.getCustomerDetail(OrderID);
                OrderDetail item = new OrderDetail(OrderID, _ServiceID, _OrderDServiceName,
                        _OrderDServicePrice, _OrderDIDevices, Pay, Status, timeStart, timeEnd, _ServiceTime, itemCustomer);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<OrderDetail> searchManageOrderAddress(String Address) throws ParseException {
        List<OrderDetail> listItem = new ArrayList<>();
        StatusDAO statusDAO = new StatusDAO();
        OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
        CustomerDetailsDAO customerDetailDAO = new CustomerDetailsDAO();

        try {
            String sql = "Select *\n"
                    + "From OrderDetails od\n"
                    + "inner join Status s\n"
                    + "on od.OrderID = s.OrderID\n"
                    + "inner join CustomerDetails cd\n"
                    + "on od.OrderID = cd.OrderID\n"
                    + "Where s.EmployeeID = 10000 and s.StatusName LIKE N'Hoạt động' and cd.CustomerAddress LIKE ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + Address + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _OrderDServiceName = rs.getString("OrderDServiceName");
                double _OrderDServicePrice = Double.parseDouble(rs.getString("OrderDServicePrice"));
                String _OrderDIDevices = rs.getString("OrderDIDevices");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String Status = rs.getString("Status");
                String Pay = rs.getString("Pay");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                String datetimeStart = rs.getString("timeStart");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                java.util.Date timeStart = dateFormat.parse(datetimeStart);

                String datetimeEnd = rs.getString("timeEnd");
                java.util.Date timeEnd = dateFormat.parse(datetimeEnd);

                CustomerDetail itemCustomer = customerDetailDAO.getCustomerDetail(OrderID);
                OrderDetail item = new OrderDetail(OrderID, _ServiceID, _OrderDServiceName,
                        _OrderDServicePrice, _OrderDIDevices, Pay, Status, timeStart, timeEnd, _ServiceTime, itemCustomer);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    //Test insertOrderDetail - chạy
    //Test getOrderDetail - chạy
    public static void main(String[] args) throws SQLException, ParseException {
        OrderDetailDAO dao = new OrderDetailDAO();
        ServicesDAO serviceDAO = new ServicesDAO();
        int orderID = 10;
        Services service = serviceDAO.details(1);
        int serviceID = service.getServiceID();
        String OrderDServiceName = "Don dep";
        double OrderDServicePrice = 240.0;
        String OrderDIDevices = "máy lạnh";
        StatusDAO statusDAO = new StatusDAO();
        String status = "Hoạt động";
        String Pay = "COD";
        Date da = new Date();
        Date da2 = new Date();
        int time = 4;
//        java.sql.Timestamp date = new java.sql.Timestamp(da.getTime());
//        java.sql.Timestamp date2 = new java.sql.Timestamp(da2.getTime());

        String dateString = "2023-06-26 00:00:00.0";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        Date date4 = dateFormat.parse(dateString);

        DateFormat df = new SimpleDateFormat("YYYY-MM-DD - hh:mm:ss");
//        System.out.println("dateFormated date is : " + df.format(timeStart));
        java.sql.Timestamp date = new java.sql.Timestamp(da.getTime());
        java.sql.Timestamp date2 = new java.sql.Timestamp(da2.getTime());
        OrderDetail item = new OrderDetail(orderID, serviceID, OrderDServiceName, OrderDServicePrice,
                OrderDIDevices, Pay, status, date, date2, time);
//        dao.insertOrderDetail(item);

//        Date d = dao.getDateByLastOrderDetail();
//        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
//        String date5 = dateFormat2.format(d.getTime());
//        java.util.Date date6 = dateFormat2.parse(date5);
//        System.out.println(date6);
//        System.out.println("Date: " + d);
//        OrderDetail or = dao.getDateLast();
//        String orDATE = dateFormat.format(or.getTimeEnd());
//        List<OrderDetail> list = dao.getListJob(1);
//        for (OrderDetail orderDetail : list) {
//            System.out.println("================================================");
//            System.out.println("Job" + orderDetail.getOrderDServiceName());
//            System.out.println("Time: " + orderDetail.getTimeStart());
//            System.out.println("Nhân viên: " + orderDetail.getEmployee().getEmployeeName());
//            System.out.println("Dịa chỉ: " + orderDetail.getEmployee().getEmployeeAddress());
//        }
//        OrderDetail od = dao.getOrderDetailbyID(52);
//        System.out.println(od.getOrderDServiceName());
        List<OrderDetail> item1 = dao.getManageOrder();
        for (OrderDetail od : item1) {
            System.out.println("OrderID: " + od.getOrderID());
            System.out.println("Dịch vụ: " + od.getOrderDServiceName());
            System.out.println("Bắt đầu: " + od.getTimeStart());
            System.out.println("Combo: " + od.getServiceTime());
            System.out.println("Trạng thái: " + od.getStatus());
        }

//              System.out.println("Khách hàng: " + od.getCustomerDetail().getCustomer().getCustomerName());
//              System.out.println("Địa chỉ: " + od.getCustomerDetail().getCustomerAddress());
    }
}
