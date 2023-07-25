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
import model.Admin;
import model.Admin;
import model.Role;

/**
 *
 * @author Asus
 */
public class AdminDAO {

    List<Admin> listAdmin;
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

    public AdminDAO(DBContext db) {
        this.db = db;
    }

    public AdminDAO() {
        this.db = new DBContext();
    }

    public AdminDAO(List<Admin> listAdmin) {
        this.listAdmin = listAdmin;
    }

    public List<Admin> getListServices() {
        return listAdmin;
    }

    private final RoleDAO dao = new RoleDAO();

    public List<Admin> read() {
        List<Admin> listItem = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Admin ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String _UsernameAdmin = rs.getString("UsernameAdmin");
                String _PassAdmin = rs.getString("PassAdmin");
                String _MailAdmin = rs.getString("MailAdmin");
                String _RoleID = rs.getString("RoleID");
                Role _RoleIDAdmin = dao.details(_RoleID);
                Admin item = new Admin(_UsernameAdmin, _PassAdmin, _MailAdmin, _RoleIDAdmin);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    public List<Admin> getAccountAdmin() {
        List<Admin> listItem = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Admin ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _UsernameAdmin = rs.getString("UsernameAdmin");
                String _PassAdmin = rs.getString("PassAdmin");
                String _MailAdmin = rs.getString("MailAdmin");
                String _RoleID = rs.getString("RoleID");
                RoleDAO roleDAO = new RoleDAO();
                Role RoleID = roleDAO.details(_RoleID);
                Admin item = new Admin(_UsernameAdmin, _PassAdmin, _MailAdmin, RoleID);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    public Admin getAccountAdminByPhone(String UsernameAdmin) {
        try {
            String sql = "select * from Admin where UsernameAdmin Like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, UsernameAdmin);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _UsernameAdmin = rs.getString("UsernameAdmin");
                String _PassAdmin = rs.getString("PassAdmin");
                String _MailAdmin = rs.getString("MailAdmin");
                String _RoleID = rs.getString("RoleID");
                RoleDAO roleDAO = new RoleDAO();
                Role RoleID = roleDAO.details(_RoleID);
                Admin item = new Admin(_UsernameAdmin, _PassAdmin, _MailAdmin, RoleID);

                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Admin details(String UsernameAdmin) {
        try {
            String sql = "select * from Admin where UsernameAdmin =?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, UsernameAdmin);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String _UsernameAdmin = rs.getString("UsernameAdmin");
                String _PassAdmin = rs.getString("PassAdmin");
                String _MailAdmin = rs.getString("MailAdmin");
                String _RoleID = rs.getString("RoleID");
                Role _RoleIDAdmin = dao.details(_RoleID);
                Admin item = new Admin(_UsernameAdmin, _PassAdmin, _MailAdmin, _RoleIDAdmin);

                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Admin edittedItem) {
        try {
            String sql = "UPDATE Admin SET PassAdmin=?, MailAdmin=?, RoleID=? WHERE UsernameAdmin=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, edittedItem.getPassAdmin());
            stmt.setString(2, edittedItem.getMailAdmin());
            stmt.setString(3, edittedItem.getRoleID().getRoleID());
            stmt.setString(4, edittedItem.getUsernameAdmin());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Admin> getAdminByUsername(String username) {
        List<Admin> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Admin WHERE UsernameAdmin=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String _UsernameAdmin = rs.getString("UsernameAdmin");
                String _PassAdmin = rs.getString("PassAdmin");
                String _MailAdmin = rs.getString("MailAdmin");
                String _RoleID = rs.getString("RoleID");
                RoleDAO roleDAO = new RoleDAO();
                Role _RoleIDAdmin = dao.details(_RoleID);
                Admin admin = new Admin(_UsernameAdmin, _PassAdmin, _MailAdmin, _RoleIDAdmin);
                list.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        List<Admin> list = dao.getAdminByUsername("0987654321");
        for (Admin admin : list) {
            System.out.println(admin);
        }
    }
}
