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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Services;

/**
 *
 * @author Asus
 */
public class CategoryDAO implements ICrud<String, Category> {

//    private final CategoryDAO category = new CategoryDAO();
    List<Category> listCategory;
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

    public CategoryDAO(DBContext db) {
        this.db = db;
    }

    public CategoryDAO() {
        this.db = new DBContext();
    }

    public CategoryDAO(List<Category> listCategory) {
        this.listCategory = listCategory;
    }

    public List<Category> getListServices() {
        return listCategory;
    }

    @Override
    public List<Category> read() {
        List<Category> listItem = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Category ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int _CatID = Integer.parseInt(rs.getString("CatID"));
                String _CatName = rs.getString("CatName");
                String _CatStatus = rs.getString("CatStatus");
                String _CatPicture = rs.getString("CatPicture");
                Category item = new Category(_CatID, _CatName, _CatStatus, _CatPicture);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    public Category details(int CatID) {
        try {
            String sql = "select * from Category where CatID =?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, CatID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _CatID = Integer.parseInt(rs.getString("CatID"));
                String _CatName = rs.getString("CatName");
                String _CatStatus = rs.getString("CatStatus");
                String _CatPicture = rs.getString("CatPicture");

                Category item = new Category(_CatID, _CatName, _CatStatus, _CatPicture);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(Category newItem) {
        String sql = "insert into Category values (?,?,?)";
        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, newItem.getCatName());
            stmt.setString(2, newItem.getCatStatus());
            stmt.setString(3, newItem.getCatPicture());
            stmt.executeUpdate(); // dùng khi muốn thêm, sửa, xóa
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Category edittedItem) {
        try {
            String sql = "UPDATE Category SET CatName=?, CatStatus=?,CatPicture=? WHERE CatID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, edittedItem.getCatName());
            stmt.setString(2, edittedItem.getCatStatus());
            stmt.setString(3, edittedItem.getCatPicture());
            stmt.setInt(4, edittedItem.getCatID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        String sql = "delete from Category where CatID=?";
        try {
            PreparedStatement st = db.getConn().prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean exists(int catID) {
        try {
            String sql = "SELECT COUNT(*) FROM Category WHERE CatID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, catID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Category";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int _CatID = Integer.parseInt(rs.getString("CatID"));
                String _CatName = rs.getString("CatName");
                String _CatStatus = rs.getString("CatStatus");
                String _CatPicture = rs.getString("CatPicture");
                Category category = new Category(_CatID, _CatName, _CatStatus, _CatPicture);
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categories;
    }

    public Category detailsbyid(String CatID) {
        List<Category> listItem = new ArrayList<>();

        try {
            String sql = "select * from Category where CatID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, CatID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _CatID = rs.getInt("CatID");
                String _CatName = rs.getString("CatName");
                String _CatStatus = rs.getString("CatStatus");
                String _CatPicture = rs.getString("CatPicture");
                Category item = new Category(_CatID, _CatName, _CatStatus, _CatPicture);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int findCategoryID(String CatName) {

        try {
            String sql = "select CatID from Category where CatName like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + CatName + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _CatID = rs.getInt("CatID");
                return _CatID;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Category detailsByName(String CatName) {
        try {
            String sql = "select * \n"
                    + "from Category c\n"
                    + "where CatName like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, "%" + CatName + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _CatID = Integer.parseInt(rs.getString("CatID"));
                String _CatName = rs.getString("CatName");
                String _CatStatus = rs.getString("CatStatus");
                String _CatPicture = rs.getString("CatPicture");

                Category item = new Category(_CatID, _CatName, _CatStatus, _CatPicture);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        String name = "Dọn dẹp";
        Category ca = c.detailsByName(name);
        System.out.println(ca.getCatStatus());

    }

    @Override
    public Category details(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
