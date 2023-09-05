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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.CustomerDetail;
import model.Employee;
import model.Order;
import model.OrderDetail;
import model.Status;

/**
 *
 * @author Asus
 */
public class OrdersDAO {

    List<Order> listOrder;

    private static Connection con = null;
    private static PreparedStatement stm = null;
    private static ResultSet rs = null;
    private DBContext db;
    EmployeeDAO eDao = new EmployeeDAO();
    CustomerDAO cDao = new CustomerDAO();
    OrderDetailDAO orderDDAO = new OrderDetailDAO();
    OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public OrdersDAO(DBContext db) {
        this.db = db;
    }

    public OrdersDAO() {
        this.db = new DBContext();
    }

    public OrdersDAO(List<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }

    public void create(Order newItem) {
        String sql = "insert into Orders values (?,?,?)";

        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
//            stmt.setInt(1, newItem.getOrderID());
            stmt.setInt(1, newItem.getCustomer().getCustomerID());
            stmt.setInt(2, newItem.getEmployee().getEmployeeID());
            stmt.setString(3, newItem.getOrderNote());

            stmt.executeUpdate(); // dùng khi muốn thêm, sửa, xóa
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Lấy OrderID mới nhất - để create OrderDetails.
    public int getIDByLastOrder() throws SQLException {
        try {
            String sql = "select top 1 * from Orders order by OrderID desc";
            PreparedStatement stmt;
            stm = db.getConn().prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } //end if connection is existed
        catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public Order details(int OrderID) {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        try {
            String sql = "select * from Orders where OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                Customer CustomerID = cDao.details(_CustomerID);
                Employee EmployeeID = eDao.details(_EmployeeID);
                Order item = new Order(OrderID, _OrderNote, CustomerID, EmployeeID);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Order getOrderByID(int OrderID) {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        try {
            String sql = "select * from Orders where OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                Customer CustomerID = cDao.details(_CustomerID);
                Employee Employee = eDao.details(_EmployeeID);
                Order item = new Order(_OrderID, _OrderNote, CustomerID, Employee);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Order getOrderByOrderDetail(int OrderID) throws ParseException {
        List<Order> listItem = new ArrayList<>();
        try {
            String sql = "select * from Orders o\n"
                    + "inner join OrderDetails od\n"
                    + "on o.OrderID = od.OrderID\n"
                    + "Where o.OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                OrderDetail OrderDetail = orderDDAO.getBill(OrderID);
                Customer CustomerID = cDao.details(_CustomerID);
                Employee Employee = eDao.details(_EmployeeID);
                Order item = new Order(OrderID, _OrderNote, CustomerID, Employee, OrderDetail);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Order> getOrderList(int EmployeeID) throws ParseException {
        List<Order> listItem = new ArrayList<>();
        try {
            String sql = "select * from Orders o\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "inner join OrderDetails od\n"
                    + "on o.OrderID = od.OrderID\n"
                    + "where s.StatusName LIKE N'Hoạt động' and o.EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                OrderDetail OrderDetail = orderDDAO.getBill(OrderID);
                Customer CustomerID = cDao.details(_CustomerID);
                Employee Employee = eDao.details(_EmployeeID);
                Order item = new Order(OrderID, _OrderNote, CustomerID, Employee, OrderDetail);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public Order getOrderID(int EmployeeID) throws ParseException {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        try {
            String sql = "select * from Orders where EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                Customer Customer = cDao.details(_CustomerID);
                Employee Employee = eDao.details(_EmployeeID);
                OrderDetail OrderDetail = OrderDetailDAO.getBill(OrderID);
                Order item = new Order(OrderID, _OrderNote, Customer, Employee, OrderDetail);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Order getOrderBYID(int EmployeeID) {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        try {
            String sql = "select * from Orders o\n"
                    + "inner join OrderDetails od\n"
                    + "on o.OrderID = od.OrderID\n"
                    + "where o.EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                Customer CustomerID = cDao.details(_CustomerID);
                Employee Employee = eDao.details(_EmployeeID);
                Order item = new Order(_OrderID, _OrderNote, CustomerID, Employee);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Order getListOrder(String phone) {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        try {
            String sql = "Select o.OrderID, o.CustomerID, o.EmployeeID, o.OrderNote\n"
                    + "From Customer c\n"
                    + "inner join Orders o\n"
                    + "on c.CustomerID = o.CustomerID\n"
                    + "Where c.Phone = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, phone);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                Customer CustomerID = cDao.details(_CustomerID);
                Employee EmployeeID = eDao.details(_EmployeeID);
                Order item = new Order(_OrderID, _OrderNote, CustomerID, EmployeeID);
//                listItem.add(item);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Order> getEmployeeHome(int EmployeeID) throws ParseException {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        StatusDAO statusDAO = new StatusDAO();
        OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
        CustomerDetailsDAO customerDetailDAO = new CustomerDetailsDAO();
        try {
            String sql = "select distinct* \n"
                    + "from CustomerDetails cd\n"
                    + "inner join Orders o\n"
                    + "on cd.OrderID = o.OrderID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "inner join OrderDetails od\n"
                    + "on o.OrderID = od.OrderID\n"
                    + "where s.StatusName LIKE N'Hoạt động' and o.EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                CustomerDetail CustomerDetail = customerDetailDAO.getCustomerNew(_CustomerID, _OrderID);
                OrderDetail OrderDetail = OrderDetailDAO.getObjectEmployee(EmployeeID, _OrderID);
                Status s = statusDAO.getStatus(_OrderID);
                Customer CustomerID = cDao.details(_CustomerID);
                Employee Employee = eDao.details(_EmployeeID);

                Order item = new Order(_OrderID, _OrderNote, CustomerDetail, CustomerID, Employee, s, OrderDetail);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<Order> getOrderEmployee(String EmployeeName) {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        StatusDAO statusDAO = new StatusDAO();
        try {
            String sql = "select o.OrderID, o.CustomerID, o.EmployeeID, o.OrderNote, s.OrderDate, s.StatusName\n"
                    + "from Orders o \n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "inner join Employee e\n"
                    + "on o.EmployeeID = e.EmployeeID\n"
                    + "Where s.StatusName Like N'Hoạt động' and e.EmployeeName LIKE ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + EmployeeName + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                Status s = statusDAO.getStatus(_OrderID);
                Customer CustomerID = cDao.details(_CustomerID);
                Employee EmployeeID = eDao.details(_EmployeeID);
//                Order item = new Order(_OrderID, _OrderNote, CustomerID, EmployeeID);
//                listItem.add(item);
                Order item = new Order(_OrderID, _OrderNote, CustomerID, EmployeeID, s);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<Order> getOrderEmployeeName(String EmployeeName) {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        StatusDAO statusDAO = new StatusDAO();
        try {
            String sql = "select o.OrderID, o.CustomerID, o.EmployeeID, o.OrderNote, s.OrderDate, s.StatusName\n"
                    + "from Orders o \n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "inner join Employee e\n"
                    + "on o.EmployeeID = e.EmployeeID\n"
                    + "Where s.StatusName Like N'Hoạt động' and e.EmployeeName LIKE ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + EmployeeName + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                Status s = statusDAO.getStatus(_OrderID);
                Customer CustomerID = cDao.details(_CustomerID);
                Employee EmployeeID = eDao.details(_EmployeeID);
//                Order item = new Order(_OrderID, _OrderNote, CustomerID, EmployeeID);
//                listItem.add(item);
                Order item = new Order(_OrderID, _OrderNote, CustomerID, EmployeeID, s);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public Order getBill(int OrderID) throws ParseException {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        StatusDAO statusDAO = new StatusDAO();
        OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
        CustomerDetailsDAO customerDetailDAO = new CustomerDetailsDAO();
        try {
            String sql = "select * from Orders o\n"
                    + "Inner join OrderDetails od\n"
                    + "on od.OrderID = o.OrderID\n"
                    + "inner join CustomerDetails c\n"
                    + "on o.OrderID = c.OrderID\n"
                    + "Where od.OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                CustomerDetail CustomerDetail = customerDetailDAO.getCustomerNew(_CustomerID, _OrderID);
                OrderDetail OrderDetail = OrderDetailDAO.getBill(OrderID);
                Status s = statusDAO.getStatus(_OrderID);
                Customer CustomerID = cDao.details(_CustomerID);
                Employee Employee = eDao.details(_EmployeeID);

                Order item = new Order(_OrderID, _OrderNote, CustomerDetail, CustomerID, Employee, s, OrderDetail);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Order getManageOrderItem(int OrderID) throws ParseException {
        CategoryDAO catD = new CategoryDAO();
        StatusDAO statusDAO = new StatusDAO();
        OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
        CustomerDetailsDAO customerDetailDAO = new CustomerDetailsDAO();
        try {
            String sql = "Select *\n"
                    + "From Orders o \n"
                    + "inner join OrderDetails od\n"
                    + "on o.OrderID = od.OrderID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "Where o.EmployeeID = 10000 and s.StatusName LIKE N'Hoạt động' and o.OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                CustomerDetail CustomerDetail = customerDetailDAO.getCustomerNew(_CustomerID, _OrderID);
                OrderDetail OrderDetail = OrderDetailDAO.getObjectEmployee(_EmployeeID, _OrderID);
                Status s = statusDAO.getStatus(_OrderID);
                Customer CustomerID = cDao.details(_CustomerID);
                Employee Employee = eDao.details(_EmployeeID);

                Order item = new Order(OrderID, _OrderNote, CustomerDetail, CustomerID, Employee, s, OrderDetail);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void deleteOrder(int OrderID) {
        String sql = "Delete from Orders where OrderID = ?";
        try {
            PreparedStatement st = db.getConn().prepareStatement(sql);
            st.setInt(1, OrderID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Order> getBill() {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "select * from OrderDetails o\n"
                    + "INNER JOIN Status s ON o.OrderID = s.OrderID\n"
                    + "WHERE s.StatusName LIKE N'Hoàn thành' AND MONTH(o.timeStart) = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                list.add(new Order(_OrderID));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Order> getBillTotal() {
        List<Order> list = new ArrayList<>();
        try {
            Calendar calendar = Calendar.getInstance();
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            String sql = "  SELECT *\n"
                    + "FROM OrderDetails o\n"
                    + "INNER JOIN Status s ON o.OrderID = s.OrderID\n"
                    + "INNER JOIN ConfirmPay cp ON s.StatusID = cp.StatusID\n"
                    + "WHERE s.StatusName LIKE N'Hoàn thành' AND cp.ConfirmEmp LIKE N'Done' AND MONTH(o.timeStart) = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                list.add(new Order(_OrderID));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //Manage - chia công việc 
    public void updateOrder(Order edittedItem) {
        try {
            String sql = "Update Orders SET EmployeeID = ? Where OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setInt(1, edittedItem.getEmployee().getEmployeeID());
            stmt.setInt(2, edittedItem.getOrderID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Update - ghi chú
    public void updateOrderNote(Order edittedItem) {
        try {
            String sql = "Update Orders SET OrderNote = ? Where OrderID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, edittedItem.getOrderNote());
            stmt.setInt(2, edittedItem.getOrderID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getSumOrder(int CustomerID) {
        CategoryDAO catD = new CategoryDAO();
        OrdersDAO cDao = new OrdersDAO();
        EmployeeDAO eDao = new EmployeeDAO();
        int Count = 0;
        try {
            String sql = "Select SUM(od.OrderDServicePrice)\n"
                    + "from Orders o\n"
                    + "inner join OrderDetails od\n"
                    + "on o.OrderID = od.OrderID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "where o.CustomerID = ? and s.OrderDate >= '2023-01-01' and s.OrderDate <= '2023-12-31'";
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

    public List<Order> getLoadOrder() throws ParseException {
        List<Order> listItem = new ArrayList<>();
        CategoryDAO catD = new CategoryDAO();
        StatusDAO statusDAO = new StatusDAO();
        OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
        CustomerDetailsDAO customerDetailDAO = new CustomerDetailsDAO();
        try {
            String sql = "Select *\n"
                    + "From Orders o \n"
                    + "inner join OrderDetails od\n"
                    + "on o.OrderID = od.OrderID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "Where o.EmployeeID != 10000 and s.StatusName LIKE N'Hoạt động'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _OrderID = Integer.parseInt(rs.getString("OrderID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _OrderNote = rs.getString("OrderNote");

                CustomerDetail CustomerDetail = customerDetailDAO.getCustomerNew(_CustomerID, _OrderID);
                OrderDetail OrderDetail = OrderDetailDAO.getObjectEmployee(_EmployeeID, _OrderID);
                Status s = statusDAO.getStatus(_OrderID);
                Customer CustomerID = cDao.details(_CustomerID);
                Employee Employee = eDao.details(_EmployeeID);

                Order item = new Order(_OrderID, _OrderNote, CustomerDetail, CustomerID, Employee, s, OrderDetail);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    //Test details - chạy
    //Test create - Chạy
    public static void main(String[] args) throws SQLException, ParseException {
        OrdersDAO o = new OrdersDAO();
//        CustomerDAO cDao = new CustomerDAO();
//        Customer customer = cDao.getAccountbyPhone("123456782");
//        EmployeeDAO empDAO = new EmployeeDAO();
//        Employee employee = empDAO.details(1);
//
//        String OrderNote = "";
//        Order order = new Order(OrderNote, customer, employee);
//        o.create(order);
//        String name = "Trần Văn Bưởi";
//        List<Order> list = o.getEmployeeHome(22);
//        for (Order order : list) {
//            System.out.println("Mã dịch vụ: " + order.getOrderID());
//            System.out.println("Tên dịch vụ: " + order.getOrderDetail().getOrderDServiceName());
//            System.out.println("Giờ: " + order.getOrderDetail().getServiceTime());
//            System.out.println("Giá " + order.getOrderDetail().getOrderDServicePrice());
//            System.out.println("Tên khách hàng:" + order.getCustomer().getCustomerName());
//            System.out.println("Phone:" + order.getCustomer().getPhone());
//            System.out.println("Địa chỉ:" + order.getCustomerDetail().getPhone());
//            System.out.println("Hình thức thanh toán: " + order.getOrderDetail().getPay());
//            System.out.println("Tên nhân viên: " + order.getEmployee().getEmployeeName());
//            System.out.println("Note: " + order.getOrderNote());
//            System.out.println("Trạng thái: " + order.getStatus().getStatusName());
//            System.out.println("Thời gian bắt đầu: " + order.getOrderDetail().getTimeStart());
//            System.out.println("Thời gian kết thúc: " + order.getOrderDetail().getTimeEnd());
//            System.out.println("Chi tiết công việc: " + order.getOrderDetail().getOrderDIDevics());
//            System.out.println("======================================================");
//        }
//        Order order = o.getOrderByOrderDetail(200);
//        System.out.println("Tên khách hàng: " + order.getCustomer().getCustomerName());
//        System.out.println("Phone: " + order.getCustomer().getPhone());
//        System.out.println("Nhân viên " + order.getEmployee().getEmployeeName());
//        System.out.println("Dịch vụ: " + order.getOrderDetail().getOrderDServiceName());
//        System.out.println("Time " + order.getOrderDetail().getTimeStart());
//        System.out.println("Time " + order.getOrderDetail().getTimeEnd());

//        List<Order> list = o.getLoadOrder();
//        for (Order order : list) {
//            System.out.println("======================================================");
//            System.out.println(order.getCustomer().getCustomerName());
//            System.out.println(order.getOrderID());
//            System.out.println(order.getOrderDetail().getOrderDServiceName());
//            System.out.println(order.getEmployee().getEmployeeName());
//            System.out.println("Time start: " + order.getOrderDetail().getTimeStart());
//            System.out.println("Time End" + order.getOrderDetail().getTimeEnd());
//            System.out.println("Status " + order.getStatus().getStatusName());
//        }
//        Order i = o.getManageOrderItem(123);
//        System.out.println("Trạng thái: " + i.getStatus().getStatusName());
//        System.out.println("Giờ: " + i.getOrderDetail().getServiceTime());
//        System.out.println("Địa chỉ: " + i.getCustomerDetail().getCustomerAddress());
          List<Order> l = o.getBillTotal();
          for (Order order : l) {
              System.out.println("Total: " + order.getOrderID());
        }
    }
}
