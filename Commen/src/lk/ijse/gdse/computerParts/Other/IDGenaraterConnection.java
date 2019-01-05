package lk.ijse.gdse.computerParts.Other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IDGenaraterConnection {
    private Connection connection;
    private static IDGenaraterConnection dBConnection;
    private IDGenaraterConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/clickcomputer", "root","1234");
    }
    public static IDGenaraterConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dBConnection==null){
            dBConnection=new IDGenaraterConnection();
        }
        return dBConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
