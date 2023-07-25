package dao;

import MyUitl.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.Category;
import model.Services;

/**
 *
 * @author Asus
 */
public class ServicesDAO  {

//    private final CategoryDAO category = new CategoryDAO();
    List<Services> listServices;
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

    public ServicesDAO(DBContext db) {
        this.db = db;
    }

    public ServicesDAO() {
        this.db = new DBContext();
    }

    public ServicesDAO(List<Services> listServices) {
        this.listServices = listServices;
    }

    public List<Services> getListServices() {
        return listServices;
    }


    public List<Services> read() {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = "select s.ServiceID, s.ServiceName, s.ServiceDetail,s.ServicePicture, s.ServicePrice, s.ServiceTime, s.ServiceStatus, s.CatID\n"
                    + "from Services s\n"
                    + "inner join Category c\n"
                    + "on s.CatID = c.CatID";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");    
                String _ServiceStatus = rs.getString("ServiceStatus");
                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, 
                        _ServicePrice, _ServicePicture, _ServiceStatus, _CatID);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }
    private static final String INDEX = "select * from Services";

    public List<Services> getList() throws ClassNotFoundException, SQLException {
        List<Services> listOfUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INDEX);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                    String _ServiceName = rs.getString("ServiceName");
                    String _ServiceDetail = rs.getString("ServiceDetail");
                    int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                    double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                    String _ServicePicture = rs.getString("ServicePicture");

                    String CatID = rs.getString("CatID");
                    Category _CatID = dao.details(CatID);
                    listOfUser.add(new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _CatID));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return listOfUser;
    }
    private final CategoryDAO dao = new CategoryDAO();

    public Services details(int ServiceID) {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = "Select *\n"
                    + "From Services\n"
                    + "Where ServiceID =  ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, ServiceID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");

                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _CatID);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Services detailsbyid(String ServiceID) {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = "select * from Services where ServiceID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, ServiceID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = rs.getInt("ServiceID");
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");

                int CatID = rs.getInt("CatID");
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _CatID);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Services getServiceByID(int serviceID) {
        try {
            String sql = "SELECT * FROM Services WHERE ServiceID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, serviceID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");

                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _CatID);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Services> detailsByCat() {
        List<Services> listItem = new ArrayList<>();
        CategoryDAO dao = new CategoryDAO();
        try {
            String sql = "SELECT c.CatName , s.ServiceName , s.ServiceTime, s.ServicePrice, s.ServicePicture\n"
                    + "FROM Services s\n"
                    + "JOIN Category c ON s.CatID = c.CatID";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
//            stmt.setInt(1, catID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String CatName = rs.getString("CatName");
                Category _CatName = dao.details(CatName);
                String ServiceName = rs.getString("ServiceName");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double ServicePrice = rs.getDouble("ServicePrice");
                String _ServicePicture = rs.getString("ServicePicture");
//                int CatID = Integer.parseInt(rs.getString("CatID"));
//                Category _CatID = dao.details(CatID); // Assuming you have a method to retrieve category details

                Services item = new Services(_CatName, ServiceName, _ServiceTime, ServicePrice, _ServicePicture);

                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<Services> detailsby(int ServiceID) {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = "select * from Services where ServiceID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, ServiceID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");

//                String CatID = rs.getString("CatID");
//                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    //lấy ID tạo voucher
    public List<Services> getAllServices() {
        List<Services> services = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Services";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");

//                String CatID = rs.getString("CatID");
//                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture);
                services.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return services;
    }

    public void create(Services newItem) {
        String sql = "insert into Services values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, newItem.getServiceID());
            stmt.setString(2, newItem.getServiceName());
            stmt.setString(3, newItem.getServiceDetail());
            stmt.setInt(4, newItem.getServiceTime());
            stmt.setDouble(5, newItem.getServicePrice());
            stmt.setString(6, newItem.getServicePicture());
            stmt.setObject(7, newItem.getCatID().getCatID());
            stmt.executeUpdate(); // dùng khi muốn thêm, sửa, xóa
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Services edittedItem) {
        try {
            String sql = "UPDATE Services SET ServiceName=?, ServiceDetail=?, ServiceTime=?, ServicePrice=?, ServicePicture=?, CatID=? WHERE ServiceID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, edittedItem.getServiceName());
            stmt.setString(2, edittedItem.getServiceDetail());
            stmt.setInt(3, edittedItem.getServiceTime());
            stmt.setDouble(4, edittedItem.getServicePrice());
            stmt.setString(5, edittedItem.getServicePicture());
            stmt.setObject(6, edittedItem.getCatID().getCatID());
            stmt.setInt(7, edittedItem.getServiceID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        String sql = "delete from Services where ServiceID=?";
        try {
            PreparedStatement st = db.getConn().prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Services> searchByName(String searchName) {
        List<Services> listSearch = new ArrayList<>();

        try {
            //2.Create sql String
            String sql = "select * from Services where ServiceName like ? ";
            //1.Get connection - 3.Create statement.
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setNString(1, "%" + searchName + "%");
            //4.Execute Query
            ResultSet rs = stmt.executeQuery();
            //5.Process result
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                String _ServicePicture = rs.getString("ServicePicture");
                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail,
                        _ServiceTime, _ServicePrice, _ServicePicture, _CatID);
                listSearch.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return listSearch;
    }

    public void getProductForCheckOut(String id)
            throws SQLException, NamingException {

        try {

            //2. Create sql string
            String sql = "Select *\n"
                    + "From Services \n"
                    + "Where ServiceID = ?";
            //1. Get connection                
            //3. Create statement
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setNString(1, "%" + id + "%");
            //4. Execute Query
            rs = stmt.executeQuery();
            //5. Process result
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");

                String CatID = rs.getString("CatID");
                Category _CatID = dao.details(CatID);
                //Create DTO instance
                Services dto = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _CatID);

                if (this.listServices == null) {
                    this.listServices = new ArrayList<>();
                }
                this.listServices.add(dto);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Services> getTopService() {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = " select top 3 *\n"
                    + "from Services";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                String _ServicePicture = rs.getString("ServicePicture");

                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServicePicture);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public String createAndGetID(Services newItem) {
        String generatedID = null;
        String sql = "INSERT INTO Services (ServiceName, ServiceDetail, ServiceTime, ServicePrice, ServicePicture, CatID) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, newItem.getServiceName());
            stmt.setString(2, newItem.getServiceDetail());
            stmt.setInt(3, newItem.getServiceTime());
            stmt.setDouble(4, newItem.getServicePrice());
            stmt.setString(5, newItem.getServicePicture());
            stmt.setInt(6, newItem.getCatID().getCatID());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedID = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generatedID;
    }

    public Services getServiceByName(String ServiceName) {
        List<Services> listItem = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Services WHERE ServiceName like ? ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + ServiceName + "%");
//            stmt.setDouble(2, ServicePrice);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");

                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _CatID);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Services> detailsby(String ServiceName) {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = "select * from Services where ServiceName like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + ServiceName + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");

//                String CatID = rs.getString("CatID");
//                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<Services> detailServices(int id) {
        List<Services> listItem = new ArrayList<>();
        try {
//            String sql = "select  s.mancc, s.madm, s.masp, s.tensp, s.soluong, s.trangthai, s.dongia, s.mota, s.hinhhanh\n"
            String sql = "select s.CatID, s.ServiceID, s.ServiceName, s.ServiceDetail, s.ServiceTime, s.ServicePrice, s.ServicePicture \n"
                    + "                    from Category n\n"
                    + "                     inner join Services s\n"
                    + "                     on n.CatID = s.CatID\n"
                    + "                     where n.CatID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServicesID = rs.getInt("ServiceID");
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = rs.getDouble("ServicePrice");
                String _ServicePicture = rs.getString("ServicePicture");
                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServicesID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _CatID);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    public Services getServiceStatus(int serviceID) {
        try {
            String sql = "SELECT * FROM Services WHERE ServiceID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, serviceID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");
                String _ServiceStatus = rs.getString("ServiceStatus");
                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _ServiceStatus, _CatID);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateService(Services edittedItem) {
        try {
            String sql = "Update  Services\n"
                    + "Set ServiceStatus  = N'Tạm dừng'\n"
                    + "Where ServiceID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

//            stmt.setString(1, edittedItem.getServiceStatus());
            stmt.setInt(1, edittedItem.getServiceID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatusHoatDong(Services edittedItem) {
        try {
            String sql = "Update  Services\n"
                    + "Set ServiceStatus  = N'Hoạt động'\n"
                    + "Where ServiceID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

//            stmt.setString(1, edittedItem.getServiceStatus());
            stmt.setInt(1, edittedItem.getServiceID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Services> readAlpha() {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = "SELECT * FROM services ORDER BY ServiceName ASC\n";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");
                String _ServiceStatus=rs.getString("ServiceStatus");
                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _CatID,_ServiceStatus);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }
    public List<Services> readAlphaZA() {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = "SELECT * FROM services ORDER BY ServiceName DESC\n";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");
                String _ServiceStatus=rs.getString("ServiceStatus");
                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceTime, _ServicePrice, _ServicePicture, _CatID,_ServiceStatus);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }
    public List<Services> readPriceAZ() {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = "  SELECT * FROM services ORDER BY ServicePrice ASC\n";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                Double _ServiceTime = Double.parseDouble(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");
                String _ServiceStatus=rs.getString("ServiceStatus");
                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, _ServiceID, 
                        _ServicePrice, _ServicePicture, _ServiceStatus, _CatID);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

     public List<Services> readPriceZA() {
        List<Services> listItem = new ArrayList<>();

        try {
            String sql = "  SELECT * FROM services ORDER BY ServicePrice DESC\n";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                String _ServiceName = rs.getString("ServiceName");
                String _ServiceDetail = rs.getString("ServiceDetail");
                int _ServiceTime = Integer.parseInt(rs.getString("ServiceTime"));
                double _ServicePrice = Double.parseDouble(rs.getString("ServicePrice"));
                String _ServicePicture = rs.getString("ServicePicture");
                String _ServiceStatus=rs.getString("ServiceStatus");
                int CatID = Integer.parseInt(rs.getString("CatID"));
                Category _CatID = dao.details(CatID);
                Services item = new Services(_ServiceID, _ServiceName, _ServiceDetail, 
                        _ServiceTime, _ServicePrice, _ServicePicture, _CatID,_ServiceStatus);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public static void main(String[] args) throws SQLException, NamingException {
        ServicesDAO dao = new ServicesDAO();
        List<Services> list = dao.readPriceAZ();
        for (Services services : list) {
            System.out.println(services.getStatus());
        }

    }
}
