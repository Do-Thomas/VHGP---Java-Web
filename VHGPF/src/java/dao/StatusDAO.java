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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Employee;
import model.Order;
import model.OrderDetail;
import model.Status;

/**
 *
 * @author Asus
 */
public class StatusDAO {

    List<Status> listStatus;

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

    public StatusDAO(DBContext db) {
        this.db = db;
    }

    public StatusDAO() {
        this.db = new DBContext();
    }

    public StatusDAO(List<Status> listStatus) {
        this.listStatus = listStatus;
    }

    public List<Status> getListStatus() {
        return listStatus;
    }

    public List<Status> read() {
        List<Status> listItem = new ArrayList<>();
        try {
            String sql = "select * from Status";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = rs.getDate("OrderDate");
                Order order = orderDAO.details(_OrderID);
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                Employee Employee = employeeDAO.details(_EmployeeID);

                Status item = new Status(_StatusID, _StatusName, _OrderDate, order, Employee);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public Status details(Integer OrderID) {
        try {
            String sql = " Select s.StatusID, s.StatusName, s.OrderDate, o.OrderID\n"
                    + " from Status s\n"
                    + " inner join Orders o\n"
                    + " on s.OrderID = o.OrderID\n"
                    + " where o.OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = rs.getDate("OrderDate");
                Order order = orderDAO.details(_OrderID);

                Status item = new Status(_StatusID, _StatusName, _OrderDate, order);

                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void create(Status newItem) {
        String sql = "insert into Status values (?,?,?,?)";

        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
//            stmt.setInt(1, newItem.getStatusID());
            stmt.setString(1, newItem.getStatusName());
            stmt.setInt(2, newItem.getOrder().getOrderID());
            stmt.setDate(3, (Date) newItem.getOrderDate());
            stmt.setDouble(4, newItem.getEmployee().getEmployeeID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Status getStatus(int OrderID) {
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = " Select *\n"
                    + " from Status s\n"
                    + " inner join Orders o\n"
                    + " on s.OrderID = o.OrderID\n"
                    + " where o.OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = rs.getDate("OrderDate");
                Order order = orderDAO.details(_OrderID);
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                Employee Employee = eDao.details(_EmployeeID);

                Status item = new Status(_StatusID, _StatusName, _OrderDate, order, Employee);

                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Status> getOrderEmployee(int EmployeeID) {
        List<Status> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "Select *\n"
                    + "from Status s\n"
                    + "inner join Orders o \n"
                    + "on s.OrderID = o.OrderID\n"
                    + "where s.StatusName Like N'Hoạt động' and o.EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = Date.valueOf(rs.getString("OrderDate"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));

                Order OrderID = cDao.details(_OrderID);
                Employee Employee = eDao.details(_EmployeeID);
                Status item = new Status(_StatusID, _StatusName, _OrderDate, OrderID, Employee);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public Status getEmployeeByID(int EmployeeID) {
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "Select *\n"
                    + "from Status s\n"
                    + "inner join Orders o \n"
                    + "on s.OrderID = o.OrderID\n"
                    + "where s.StatusName Like N'Hoạt động' and o.EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = Date.valueOf(rs.getString("OrderDate"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));

                Order OrderID = cDao.details(_OrderID);
                Employee Employee = eDao.details(_EmployeeID);
                Status item = new Status(_StatusID, _StatusName, _OrderDate, OrderID, Employee);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void updateStatusEmployee(Status edittedItem) {
        try {
            String sql = "Update Status SET EmployeeID = ? Where  OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setInt(1, edittedItem.getEmployee().getEmployeeID());
            stmt.setInt(2, edittedItem.getOrder().getOrderID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatusFinished(Status edittedItem) {
        try {
            String sql = "Update Status SET StatusName = N'Hoàn thành' Where  OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setInt(1, edittedItem.getOrder().getOrderID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Status> getListOrder() {
        List<Status> listItem = new ArrayList<>();
        try {
            String sql = "select top 15 * from Status\n"
                    + "Where OrderDate <= GETDATE()\n"
                    + "Order By OrderDate Desc";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = rs.getDate("OrderDate");
                Order order = orderDAO.details(_OrderID);
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                Employee Employee = employeeDAO.details(_EmployeeID);

                Status item = new Status(_StatusID, _StatusName, _OrderDate, order, Employee);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<Status> getAllOrder() {
        List<Status> listItem = new ArrayList<>();
        try {
            String sql = "select * from Status";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = rs.getDate("OrderDate");
                Order order = orderDAO.details(_OrderID);
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                Employee Employee = employeeDAO.details(_EmployeeID);

                Status item = new Status(_StatusID, _StatusName, _OrderDate, order, Employee);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<Status> getAllOrderStatus(String Status) throws ParseException {
        List<Status> listItem = new ArrayList<>();
        try {
            String sql = "select * from Status where not EmployeeID = 10000 and StatusName LIKE ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + Status + "%");
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = rs.getDate("OrderDate");
                Order order = orderDAO.details(_OrderID);
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                Employee Employee = employeeDAO.details(_EmployeeID);
//                OrderDetail OrderDetail = orderDetailDAO.getBill(_OrderID);

                Status item = new Status(_StatusID, _StatusName, _OrderDate, order, Employee);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public int getCountOrder(int EmployeeID) {
        int Count = 0;
        try {
            String sql = "SELECT COUNT(o.OrderID)\n"
                    + "From Status s\n"
                    + "Inner join Orders o\n"
                    + "On s.OrderID = o.OrderID\n"
                    + "Where s.StatusName LIKE N'Hoàn thành' and o.EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
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

    public Status getStatusbyID(int StatusID) throws ParseException {
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
        try {
            String sql = "select *\n"
                    + "from Status s\n"
                    + "inner join OrderDetails od\n"
                    + "on s.OrderID = od.OrderID\n"
                    + "where s.StatusID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, StatusID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = Date.valueOf(rs.getString("OrderDate"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));

                Order OrderID = cDao.details(_OrderID);
                Employee Employee = eDao.details(_EmployeeID);
                OrderDetail OrderDetail = OrderDetailDAO.getBill(_OrderID);

                Status item = new Status(StatusID, _StatusName, _OrderDate, OrderID, Employee, OrderDetail);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void updateStatusCancel(Status edittedItem) {
        try {
            String sql = "Update Status SET StatusName = N'Hủy' Where  OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setInt(1, edittedItem.getOrder().getOrderID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Status> getListEmployeeWork(String Building) throws ParseException {
        List<Status> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "select  e.EmployeeID, COUNT(s.EmployeeID) as 'TotalWork', COUNT(e.EmployeeID) as 'TotalEmp'\n"
                    + "from Status s\n"
                    + "join Employee e\n"
                    + "on s.EmployeeID = e.EmployeeID\n"
                    + "where s.StatusName LIKE N'Hoạt động' and not s.EmployeeID = 10000 and e.Building LIKE ?\n"
                    + "Group by   s.EmployeeID, e.EmployeeID";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + Building + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
//                String _StatusName = rs.getString("StatusName");
//                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
//                Date _OrderDate = Date.valueOf(rs.getString("OrderDate"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                int Total = Integer.parseInt(rs.getString("TotalWork"));
//                Order OrderID = cDao.details(_OrderID);
                Employee Employee = eDao.details(_EmployeeID);
                OrderDetail od = orderDetailDAO.getEmployeeItem(_EmployeeID);
                Status item = new Status(Total, Employee, od);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<Status> getListEmployee(String Building) throws ParseException {
        List<Status> listItem = new ArrayList<>();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        try {
            String sql = "select  *\n"
                    + "from Status s\n"
                    + "join Employee e\n"
                    + "on s.EmployeeID = e.EmployeeID\n"
                    + "where s.StatusName LIKE N'Hoạt động' and not s.EmployeeID = 10000 and e.Building LIKE ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + Building + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _StatusID = Integer.parseInt(rs.getString("StatusID"));
                String _StatusName = rs.getString("StatusName");
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                Date _OrderDate = Date.valueOf(rs.getString("OrderDate"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                Order OrderID = cDao.details(_OrderID);
                Employee Employee = eDao.details(_EmployeeID);
                OrderDetail od = orderDetailDAO.getDetailOrder(_OrderID);
                Status item = new Status(Employee, od);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    //Test detail - OrderID - chạy
    //Test updateStatusFinished - chạy
    public static void main(String[] args) throws ParseException {
        StatusDAO s = new StatusDAO();

//        String name = "Hoạt động";
//
//        EmployeeDAO eDAO = new EmployeeDAO();
//        Employee e = eDAO.details(11);
//        Date date = new Date(0);
//        Customer customer = new Customer(3, "Gạo", "1234567892", "12345", date, "HCM", false);
//        Order order = new Order(4, "", customer, e);
//
//        Status item = new Status(name, date, order, e);
////        s.updateStatusFinished(item);
//        OrdersDAO oD = new OrdersDAO();
//        Order o = oD.getOrderByID(52);
//        Status S = new Status(o, e);
//        s.updateStatusEmployee(S);
        List<Status> item = s.getListEmployee("S8");
        for (Status status : item) {
            System.out.println("OrderID " + status.getOrderDetail().getOrderID());
            System.out.println("Nhân viên: " + status.getEmployee().getEmployeeName());
            System.out.println("Thời gian: " + status.getOrderDetail().getTimeStart() + " - " + status.getOrderDetail().getTimeEnd());

            System.out.println("Tổng: " + status.getTotal());
        }
    }

}
