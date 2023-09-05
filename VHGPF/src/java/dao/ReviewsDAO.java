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
import model.Reviews;
import model.Reviews;
import model.Services;

/**
 *
 * @author Asus
 */
public class ReviewsDAO {

    List<Reviews> listReviews;
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

    public ReviewsDAO(DBContext db) {
        this.db = db;
    }

    public ReviewsDAO() {
        this.db = new DBContext();
    }

    public ReviewsDAO(List<Reviews> listReviews) {
        this.listReviews = listReviews;
    }

    public List<Reviews> getListServices() {
        return listReviews;
    }

    public void createFeedBack(Reviews newItem) {
        String sql = "Insert into Reviews Values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setInt(1, newItem.getService().getServiceID());
            stmt.setInt(2, newItem.getCustomer().getCustomerID());
            stmt.setString(3, newItem.getReviewTitle());
            stmt.setDate(4, (Date) newItem.getReviewDate());
            stmt.setInt(5, newItem.getReviewRating());
            stmt.setString(6, newItem.getComment());
            stmt.setString(7, newItem.getReviewPicture());
            stmt.executeUpdate(); // dùng khi muốn thêm, sửa, xóa
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Reviews> getListFeedback() {
        List<Reviews> listItem = new ArrayList<>();
        try {
            String sql = "select r.ReviewID, r.CustomerID, r.ServiceID, r.Comment, r.ReviewDate, r.ReviewPicture,r.ReviewTitle, r.Comment\n"
                    + "from Reviews r\n"
                    + "inner join Customer c\n"
                    + "on r.CustomerID = c.CustomerID";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
//            stmt.setString(1, phone);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ID = Integer.parseInt(rs.getString("ReviewID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                String _ReviewTitle = rs.getString("ReviewTitle");
                Date _ReviewDate = (Date) rs.getDate("ReviewDate");
                String Comment = rs.getString("Comment");
                String _ReviewPicture = rs.getString("ReviewPicture");
                ServicesDAO serviceDAO = new ServicesDAO();
                Services s = serviceDAO.getServiceByID(_ServiceID);
                CustomerDAO customerDAO = new CustomerDAO();
                Customer c = customerDAO.getCustomerbyID(_CustomerID);

                Reviews item = new Reviews(_ID, _ReviewTitle, _ReviewDate,
                        _ServiceID, Comment, _ReviewPicture, s, c);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public List<Reviews> getFeedBackService(int ServiceID) {
        List<Reviews> listItem = new ArrayList<>();
        try {
            String sql = "select * from Reviews\n"
                    + "where ServiceID = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, ServiceID);
            rs = stmt.executeQuery();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _ID = Integer.parseInt(rs.getString("ReviewID"));
                int _ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                int _CustomerID = Integer.parseInt(rs.getString("CustomerID"));
                String _ReviewTitle = rs.getString("ReviewTitle");
                Date _ReviewDate = (Date) rs.getDate("ReviewDate");
                String Comment = rs.getString("Comment");
                String _ReviewPicture = rs.getString("ReviewPicture");
                ServicesDAO serviceDAO = new ServicesDAO();
                Services s = serviceDAO.getServiceByID(_ServiceID);
                CustomerDAO customerDAO = new CustomerDAO();
                Customer c = customerDAO.getCustomerbyID(_CustomerID);

                Reviews item = new Reviews(_ID, _ReviewTitle, _ReviewDate,
                        _ServiceID, Comment, _ReviewPicture, s, c);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    public static void main(String[] args) {
        ReviewsDAO dao = new ReviewsDAO();
        List<Reviews> list = dao.getFeedBackService(2);
        for (Reviews reviews : list) {
            System.out.println("=======================================================================");
            System.out.println("Khách hàng: " + reviews.getCustomer().getCustomerName());
            System.out.println("Dịch vụ: " + reviews.getService().getServiceName());
            System.out.println("Comment: " + reviews.getComment());
        }
    }

}
