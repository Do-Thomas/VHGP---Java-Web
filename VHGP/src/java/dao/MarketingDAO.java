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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Marketing;
import model.Services;

/**
 *
 * @author Asus
 */
public class MarketingDAO implements ICrud<String, Marketing> {

    List<Marketing> listMarketing;
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

    public MarketingDAO(DBContext db) {
        this.db = db;
    }

    public MarketingDAO() {
        this.db = new DBContext();
    }

    public MarketingDAO(List<Marketing> listMarketing) {
        this.listMarketing = listMarketing;
    }

    public List<Marketing> getListServices() {
        return listMarketing;
    }

    private final ServicesDAO dao = new ServicesDAO();

    @Override
    public List<Marketing> read() {
        List<Marketing> listItem = new ArrayList<>();

        try {
            String sql = "select m.Event, s.ServiceID, m.StartTime, m.EndTime, m.Voucher\n "
                    + "from Marketing m\n"
                    + "inner join Services s\n"
                    + "on s.ServiceID = m.ServiceID";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _Event = rs.getString("Event");
                int ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                Services _ServiceID = dao.details(ServiceID);
//String birthDayString = request.getParameter("BirthDay");

                String _StartTime = rs.getString("StartTime");
                String _EndTime = rs.getString("EndTime");
//                Date _StartTime = Date.valueOf(rs.getString("StartTime"));
//                Date _EndTime = Date.valueOf(rs.getString("EndTime"));
                int _Voucher = Integer.parseInt(rs.getString("Voucher"));

                boolean checkValidation = true;
                MarketingDAO marketingDAO = new MarketingDAO();
                Marketing newVoucher = new Marketing();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = null;
                java.util.Date datee = null;

                try {
                    date = (java.util.Date) formatter.parse(_StartTime);
                    newVoucher.setStartTime(date);
                } catch (ParseException e) {
                    newVoucher.setStartTime("Invalid start time date format.");
                    checkValidation = false;
                }

                try {
                    datee = (java.util.Date) formatter.parse(_EndTime);
                    newVoucher.setEndTime(datee);
                } catch (ParseException e) {
                    newVoucher.setEndTime("Invalid start time date format.");
                    checkValidation = false;
                }

                Marketing item = new Marketing(_Event, _ServiceID, date, datee, _Voucher);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarketingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listItem;
    }

    @Override
    public Marketing details(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Marketing newItem) {
        String sql = "INSERT INTO Marketing VALUES (?, ?, ?, ?, ?)";
        try {

            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getEvent());
            stmt.setInt(2, newItem.getServiceID().getServiceID());
//            ptm.setDate(4, new java.sql.Date(user.getBirthDay().getTime()));
            stmt.setDate(3, new java.sql.Date(newItem.getStartTime().getTime()));
            stmt.setDate(4, new java.sql.Date(newItem.getEndTime().getTime()));

//            stmt.setDate(4, (Date) newItem.getEndTime());
            stmt.setInt(5, newItem.getVoucher());
            stmt.executeUpdate(); // dùng khi muốn thêm, sửa, xóa
        } catch (SQLException ex) {
            Logger.getLogger(MarketingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    update by Event
    @Override
    public void update(Marketing edittedItem) {
        try {
            String sql = "UPDATE Marketing SET Event=?, ServiceID=?, StartTime=?, EndTime=?, Voucher=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, edittedItem.getEvent());
            stmt.setInt(2, edittedItem.getServiceID().getServiceID());
            stmt.setDate(3, new java.sql.Date(edittedItem.getStartTime().getTime()));
            stmt.setDate(4, new java.sql.Date(edittedItem.getEndTime().getTime()));
            stmt.setInt(5, edittedItem.getVoucher());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarketingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Update by event
    public Marketing detailsbyname(String Event) {
        try {
            String sql = "SELECT * FROM Marketing WHERE Event = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, Event);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String _Event = rs.getString("Event");
                int ServiceID = Integer.parseInt(rs.getString("ServiceID"));
                Services _ServiceID = dao.details(ServiceID);
//String birthDayString = request.getParameter("BirthDay");

                String _StartTime = rs.getString("StartTime");
                String _EndTime = rs.getString("EndTime");
//                Date _StartTime = Date.valueOf(rs.getString("StartTime"));
//                Date _EndTime = Date.valueOf(rs.getString("EndTime"));
                int _Voucher = Integer.parseInt(rs.getString("Voucher"));

                boolean checkValidation = true;
                MarketingDAO marketingDAO = new MarketingDAO();
                Marketing newVoucher = new Marketing();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = null;
                java.util.Date datee = null;

                try {
                    date = (java.util.Date) formatter.parse(_StartTime);
                    newVoucher.setStartTime(date);
                } catch (ParseException e) {
                    newVoucher.setStartTime("Invalid start time date format.");
                    checkValidation = false;
                }

                try {
                    datee = (java.util.Date) formatter.parse(_EndTime);
                    newVoucher.setEndTime(datee);
                } catch (ParseException e) {
                    newVoucher.setEndTime("Invalid start time date format.");
                    checkValidation = false;
                }

                Marketing item = new Marketing(_Event, _ServiceID, date, datee, _Voucher);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarketingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
