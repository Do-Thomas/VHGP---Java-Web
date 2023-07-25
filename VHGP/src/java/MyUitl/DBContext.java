package MyUitl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBContext {
    //tương tác với database
    //nếu copy lỗi nhấn Fix imports
    private Connection conn = null;
    
    public DBContext() {
        try {
            String usr = "sa";
            String pass = "12345";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=VHGP";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, usr, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//tương tác với database
//Đóng - mở Connect Database
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
            public static Connection getConnection() throws SQLException, ClassNotFoundException, NamingException { 
        Connection conn = null;
    
        Context context= new InitialContext();
        Context end = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) end.lookup("DBCon");
        conn= ds.getConnection();
        return conn;
    }
}
