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
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.Category;
import model.Employee;
import model.Order;
import model.OrderDetail;
import model.Status;

/**
 *
 * @author Asus
 */
public class EmployeeDAO {

    CategoryDAO categoryDAO = new CategoryDAO();

    public Employee checkLogin(String mail, String matkhau) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "  SELECT * from Employee\n"
                + " WHERE EmployeePhone=? AND Password=? ";
        try {
            conn = db.getConn();
            if (conn != null) {
                PreparedStatement stmt = db.getConn().prepareStatement(sql);
                stmt.setString(1, mail);
                stmt.setString(2, matkhau);
                rs = stmt.executeQuery();
                if (rs.next()) {
                   
           int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                
                    return (Employee) new Employee(_EmployeeID, _EmployeeName, _BirthDay,
                        _EmployeePhone, _EmployeeAddress, _EmployeePicture, _EmployeeGender, category);
//                    return (TaiKhoan)new TaiKhoan(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4),rs.getObject(email, type));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Employee> read() {
        List<Employee> listItem = new ArrayList<>();

        try {
            String sql = "select *\n"
                    + "from Employee e where not EmployeeID = 10000";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                int _Status = Integer.parseInt(rs.getString("Status"));
                Category ca = categoryDAO.detailsByName(_CatName);

                Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay,
                        _EmployeePhone, _EmployeeAddress, _EmployeePicture, _EmployeeGender, ca, _Status);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public void update(Employee edittedItem) {
        try {
            String sql = "Update Employee\n"
                    + "Set Status = 1\n"
                    + "Where EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setInt(1, edittedItem.getEmployeeID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Employee> listEmployee;
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

    public EmployeeDAO(DBContext db) {
        this.db = db;
    }

    public EmployeeDAO() {
        this.db = new DBContext();
    }

    public EmployeeDAO(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public Employee details(int EmployeeID) {
        List<Employee> listItem = new ArrayList<>();

        try {
            String sql = "Select *\n"
                    + "From Employee\n"
                    + "Where EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                Employee item = new Employee(EmployeeID, _EmployeeName, _BirthDay,
                        _EmployeePhone, _EmployeeAddress, _EmployeePicture, _EmployeeGender, category);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Employee> getEmployeeWork(String Building) {
        List<Employee> listItem = new ArrayList<>();

        try {
            String sql = "Select * from Employee where Status = 2 and Building LIKE ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + Building + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                int _Status = Integer.parseInt(rs.getString("Status"));
                String _Password = rs.getString("Password");

                Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay,
                        _EmployeePhone, _EmployeeAddress, _EmployeePicture, _EmployeeGender, category, _Status);
                listItem.add(item);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    //ko xài dc
    public Employee getEmployeeWorkDate(java.sql.Timestamp date1, java.sql.Timestamp date2) {
        List<Employee> listItem = new ArrayList<>();
        try {
            String sql = "Select DISTINCT  e.EmployeeName, e.EmployeeID, e.BirthDay, e.EmployeeAddress, \n"
                    + "e.EmployeeGender, e.EmployeePhone, e.Status, e.CatName from Employee e\n"
                    + "inner join Status s\n"
                    + "on e.EmployeeID = s.EmployeeID\n"
                    + "inner join OrderDetails od\n"
                    + "on s.OrderID = od.OrderID\n"
                    + "Where NOT od.timeStart >= ?\n"
                    + "And od.timeEnd <= ? and s.StatusName LIKE N'Hoàn thành'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setTimestamp(1, date1);
            stmt.setTimestamp(2, date2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                int _Status = Integer.parseInt(rs.getString("Status"));
//                String _Password = rs.getString("Password");

                StatusDAO sDAO = new StatusDAO();
                Status status = sDAO.getEmployeeByID(_EmployeeID);
                Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay, _EmployeePhone,
                        _EmployeeAddress, _EmployeePhone, _EmployeeGender, category, _Status);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Employee getEmployeebyOrderID(int OrderID) {
        List<Employee> listItem = new ArrayList<>();
        try {
            String sql = "select *\n"
                    + "from Employee e\n"
                    + "inner join Orders o\n"
                    + "on e.EmployeeID = o.EmployeeID\n"
                    + "Where o.OrderID  = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, OrderID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                int _Status = Integer.parseInt(rs.getString("Status"));
//                String _Password = rs.getString("Password");

                StatusDAO sDAO = new StatusDAO();
                Status status = sDAO.getEmployeeByID(_EmployeeID);
                Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay, _EmployeePhone,
                        _EmployeeAddress, _EmployeePhone, _EmployeeGender, category, _Status);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Employee> getListEmployeeStatus(int Status) throws ParseException {
        List<Employee> listItem = new ArrayList<>();

        try {
            String sql = "Select * from Employee e\n"
                    + "inner join Status s\n"
                    + "on e.EmployeeID = s.EmployeeID\n"
                    + "where s.StatusName LIKE N'Hoạt động' and e.Status =? and not e.EmployeeID = 10000 ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, Status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                int _Status = Integer.parseInt(rs.getString("Status"));
                String _Password = rs.getString("Password");

                OrdersDAO OrderDAO = new OrdersDAO();
                Order Order = OrderDAO.getOrderID(_EmployeeID);
                OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
                int OrderID = Order.getOrderID();
                OrderDetail OrderDetail = OrderDetailDAO.getOrderDetailbyID(OrderID);

                Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay, _EmployeePhone, _EmployeeAddress,
                        _EmployeePicture, _EmployeeGender, category, Status, OrderDetail);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<Employee> getListJob(int EmployeeID) throws ParseException {
        List<Employee> listItem = new ArrayList<>();

        try {
            String sql = "select distinct * \n"
                    + "from Employee e\n"
                    + "inner join Orders o\n"
                    + "on e.EmployeeID = o.EmployeeID\n"
                    + "inner join Status s\n"
                    + "on o.OrderID = s.OrderID\n"
                    + "inner join OrderDetails od\n"
                    + "on o.OrderID = od.OrderID\n"
                    + "Where e.EmployeeID = ?  and s.StatusName LIKE N'Hoạt động'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                int _Status = Integer.parseInt(rs.getString("Status"));

                OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                StatusDAO StatusDAO = new StatusDAO();
//                List<OrderDetail> OrderDetail = orderDetailDAO.getEmployee(EmployeeID);
//                Status Status = StatusDAO.getEmployeeByID(EmployeeID);
//
//                Employee item = new Employee(EmployeeID, _EmployeeName, _BirthDay, _EmployeePhone, 
//                        _EmployeeAddress, _EmployeePicture, _EmployeeGender, _Status, OrderDetail, Status);
//                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public Employee getAccountByPhone(String EmployeePhone) {

        try {
            String sql = "select * \n"
                    + "from Employee \n"
                    + "where EmployeePhone = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, EmployeePhone);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay,
                        EmployeePhone, _EmployeeAddress, _EmployeePicture, _EmployeeGender, category);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Employee getEmployeeByID(int EmployeeID) {

        try {
            String sql = "select * \n"
                    + "from Employee \n"
                    + "where EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, EmployeeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay,
                        _EmployeePhone, _EmployeeAddress, _EmployeePicture, _EmployeeGender, category);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static final String INSERT = "INSERT INTO Employee( EmployeeName, "
            + "BirthDay, EmployeePhone, CatName, EmployeeAddress, EmployeePicture, EmployeeGender, "
            + "Password,  RoleID, Status) VALUES(?,?,?,?,?,?,?,?,?,?)";

    public boolean insert(Employee emp) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = db.getConn();
            if (conn != null) {

                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, emp.getEmployeeName());
                ptm.setDate(2, new java.sql.Date(emp.getBirthDay().getTime()));
                ptm.setString(3, emp.getEmployeePhone());
                ptm.setString(4, emp.getCategory().getCatName());
                ptm.setString(5, emp.getEmployeeAddress());
                ptm.setString(6, emp.getEmployeePicture());
                ptm.setBoolean(7, emp.isEmployeeGender());
                ptm.setString(8, emp.getPassword());
                ptm.setString(9, emp.getRoleID()); // Assuming the Role object has an ID property
                ptm.setInt(10, emp.getStatus());
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

    public void updateEmployeeStatus(Employee edittedItem) {
        try {
            String sql = "Update Employee SET Status = 2 Where EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setInt(1, edittedItem.getEmployeeID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEmployeeStatusWork(Employee edittedItem) {
        try {
            String sql = "Update Employee SET Status = 1 Where EmployeeID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setInt(1, edittedItem.getEmployeeID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Employee getEmployeeByPhone(String EmployeePhone) {

        try {
            String sql = "select * \n"
                    + "from Employee \n"
                    + "where EmployeePhone = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, EmployeePhone);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay,
                        EmployeePhone, _EmployeeAddress, _EmployeePicture, _EmployeeGender, category);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Employee getEmployeeByName(String EmployeePhone) {

        try {
            String sql = "select * \n"
                    + "from Employee \n"
                    + "where EmployeeName LIKE ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + EmployeePhone + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _EmployeeID = Integer.parseInt(rs.getString("EmployeeID"));
                String _EmployeeName = rs.getString("EmployeeName");
                Date _BirthDay = Date.valueOf(rs.getString("BirthDay"));
                String _EmployeePhone = rs.getString("EmployeePhone");
                String _CatName = rs.getString("CatName");
                String _EmployeeAddress = rs.getString("EmployeeAddress");
                String _EmployeePicture = rs.getString("EmployeePicture");
                boolean _EmployeeGender = Boolean.getBoolean("EmployeeGender");
                Category category = categoryDAO.detailsByName(_CatName);
                Employee item = new Employee(_EmployeeID, _EmployeeName, _BirthDay,
                        EmployeePhone, _EmployeeAddress, _EmployeePicture, _EmployeeGender, category);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getCountEmployee() {
        int Count = 0;
        try {
            String sql = "Select COUNT(*) From Employee";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
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

    //Test details - chạy được
    //Test detailsbyPhone - chạy được
    public static void main(String[] args) throws SQLException, NamingException, ParseException {
        EmployeeDAO EDao = new EmployeeDAO();
        String phone = "123456789";
        int status = 2;
        int EmployeeID = 1;
        String EmployeeName = "Nguyễn Văn A";
        String EmployeePhone = "0123456789";
        String CatName = "Dọn dẹp";
        CategoryDAO dao = new CategoryDAO();
        Category category = dao.details(1);
        String EmployeeAddress = "S203, 2111";
        String EmployeePicture = "hhhh";
        boolean EmployeeGender = true;
        String RoleID = "emp";
        int Status = 1;
        String str = "2017-09-11";
        // converting string into sql date
        Date date = Date.valueOf(str);
        Employee e = new Employee(EmployeeID, EmployeeName, date, EmployeePhone,
                EmployeeAddress, EmployeePicture, EmployeeGender, RoleID, category, phone, Status);

        String text = "2023-07-27 17:28:00.000";
        java.util.Date d1 = new java.util.Date();
        Timestamp timestamp1 = Timestamp.valueOf(text);

        String date2 = "2023-07-27 21:28:00.000";
        java.util.Date d2 = new java.util.Date();
        Timestamp timestamp2 = Timestamp.valueOf(date2);
//        Employee emp = EDao.getEmployeeWorkDate(timestamp1, timestamp2);

//        List<Employee> list = EDao.getListEmployeeStatus(1);
//        for (Employee employee : list) {
//            System.out.println("=============================================================");
//            System.out.println("Nhân viên" + employee.getEmployeeName());
//            System.out.println("Order: " + employee.getConfirm());
//            System.out.println("Dịch vụ: " + employee.getOrderDetail().getOrderDServiceName());
//            System.out.println("Bắt đầu " + employee.getOrderDetail().getTimeStart());
//            System.out.println("Kết thức: " + employee.getOrderDetail().getTimeEnd());
//        }
//        Employee emp = EDao.getEmployeeByName("Lê Thị A");
//        System.out.println("ID: " + emp.getEmployeeID());
//        System.out.println("Phone " + emp.getEmployeePhone());
           int count = EDao.getCountEmployee();
           System.out.println("Tổng: " + count);
    }

}
